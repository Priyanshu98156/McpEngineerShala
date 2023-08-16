package com.priyanshu.mcpengineershala.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.ImageAdapter
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentAboutUsFragmentBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class about_us_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler

    private lateinit var imageList: ArrayList<Int>
    lateinit var adapter: ImageAdapter
    var count: Int = 0
    var dept: String = ""
    lateinit var aboutUsScreen: Home_screen_activity
    lateinit var binding: FragmentAboutUsFragmentBinding
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
        binding = FragmentAboutUsFragmentBinding.inflate(layoutInflater, container, false)
        aboutUsScreen = activity as Home_screen_activity
        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
        binding.tvIntro.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.BOLD)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)

            binding.tvIntroPara.visibility = View.VISIBLE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvMissionPara.visibility = View.GONE;

        }
        binding.tvVision.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.BOLD)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)

            binding.tvVisionPara.visibility = View.VISIBLE;
            binding.tvIntroPara.visibility = View.GONE;
            binding.tvMissionPara.visibility = View.GONE;

        }
        binding.tvMission.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.BOLD)
            binding.tvMissionPara.visibility = View.VISIBLE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvIntroPara.visibility = View.GONE;

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
//        viewPager2.currentItem = viewPager2.currentItem + 1
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
        imageList.add(R.drawable.about_us_image_2)
        imageList.add(R.drawable.about_us_image_1)
        imageList.add(R.drawable.about_us_image_3)
        imageList.add(R.drawable.about_us_image_4)

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