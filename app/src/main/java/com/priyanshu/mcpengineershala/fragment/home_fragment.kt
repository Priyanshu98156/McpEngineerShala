package com.priyanshu.mcpengineershala.fragment

import android.content.Intent
import android.net.Uri
import com.priyanshu.mcpengineershala.R
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
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.ImageAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentHomeFragmentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class home_fragment : Fragment() {
    lateinit var HomeScreen:Home_screen_activity

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding :FragmentHomeFragmentBinding

    var count :Int =0

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
        HomeScreen= activity as Home_screen_activity
       binding = FragmentHomeFragmentBinding.inflate(layoutInflater,container,false)
        HomeScreen.supportActionBar?.title = "MCPEngineerShala"
        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })

        binding.CvFeeStr.setOnClickListener {
            HomeScreen.navController.navigate(R.id.FeeStructureFragment)
//            val intent = Intent(activity,FeeStructureActivity::class.java)
//            startActivity(intent)

        }
        binding.CvSeats.setOnClickListener {
            HomeScreen.navController.navigate(R.id.seats_availability_fragment)
        }
        binding.cvCourses.setOnClickListener {
            HomeScreen.navController.navigate(R.id.courses_fragment2)
        }
        binding.Cvregister.setOnClickListener {
            HomeScreen.navController.navigate(R.id.onlineRegistrationFragment)
             }
        binding.Cvabout.setOnClickListener {
            HomeScreen.navController.navigate(R.id.about_us_fragment)
        }
        binding.CvStudentLogin.setOnClickListener {
            HomeScreen.navController.navigate(R.id.studentLoginFragment)
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
    private fun init() {
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