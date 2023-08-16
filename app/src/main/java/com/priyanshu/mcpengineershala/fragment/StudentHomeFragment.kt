package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.priyanshu.mcpengineershala.ImageAdapter
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentStudentHomeBinding
import com.priyanshu.mcpengineershala.dataclasses.Registration

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StudentHomeFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
     lateinit var adapter: ImageAdapter
    lateinit var binding: FragmentStudentHomeBinding
    var count: Int = 0


    private var param1: String? = null
    private var param2: String? = null
    lateinit var homeScreen: StudentMainScreenActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeScreen = activity as StudentMainScreenActivity
         binding = FragmentStudentHomeBinding.inflate(layoutInflater, container, false)
        var dept :String = ""
        var sem :String = ""
        var uid:String = ""

        var currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null){
            uid = currentUser.uid
        }
        FirebaseDatabase.getInstance().reference.child("Students").addValueEventListener(object:
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (each in snapshot.children){
                    var data = each.getValue(Registration::class.java)
                    if (data!= null && data.uid == uid){
                        binding.department.text = data.course
                        dept = data.course
                        sem = data.semester
                        binding.sem.text = data.semester

                        println("================================testing"+dept)
                        println("================================testing"+sem)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

        dept = binding.department.text.toString()
        sem = binding.sem.text.toString()
        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })

        binding.cvSyllabus.setOnClickListener {
            homeScreen.navController.navigate(R.id.syllabusFragment)
        }
        binding.cvContactteacher.setOnClickListener {
            homeScreen.navController.navigate(R.id.teacherListFragment)
        }
        binding.cvAnnounce.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("dept",dept)
            homeScreen.navController.navigate(R.id.announcement_fragement,bundle)
        }
        binding.cvMstRecord.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("dept",dept)
            bundle.putString("sem",sem)
            homeScreen.navController.navigate(R.id.mstFragment,bundle)

        }
        binding.cvNotes.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("dept",dept)
            bundle.putString("sem",sem)
            homeScreen.navController.navigate(R.id.NOtesFragment,bundle)
        }
        binding.cvAssignment.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("dept",dept)
            bundle.putString("sem",sem)
            homeScreen.navController.navigate(R.id.assignmentFragment,bundle)
        }
        binding.cvTimeTable.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("dept",dept)
            homeScreen.navController.navigate(R.id.timeTableFragment,bundle)
        }
        binding.cvQuestionPaper.setOnClickListener {
            homeScreen.navController.navigate(R.id.questionPaperFragment)
        }



        return binding.root
    }
    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable, 2000)
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - kotlin.math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
            page.setOnClickListener {
                when (count) {
                    0 -> {
//                        var intent = Intent(Intent.ACTION_VIEW)
//                        startActivity(intent)
                    }
                    1 -> {
//                        var intent = Intent(Intent.ACTION_VIEW)
//                        startActivity(intent)
                    }
                    2 -> {
//                        var intent = Intent(Intent.ACTION_VIEW)
//                        startActivity(intent)
                    }
                    3 -> {
//                        var intent = Intent(Intent.ACTION_VIEW)
//                        startActivity(intent)
                    }
                    4 -> {
//                        var intent = Intent(Intent.ACTION_VIEW)
//                        startActivity(intent)
                    }
                }
            }
        }

        viewPager2.setPageTransformer(transformer)
    }
     fun init() {
        viewPager2 = binding.viewpager
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.img)
        imageList.add(R.drawable.img_1)
        imageList.add(R.drawable.img_2)
        imageList.add(R.drawable.img_3)
        imageList.add(R.drawable.img_4)

        adapter = ImageAdapter(imageList, viewPager2)

        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> count = 0
                    1 -> count = 1
                    2 -> count = 2
                    3 -> count = 3
                    4 -> count = 4

                }
            }
        })


    }



}
