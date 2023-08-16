package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentSyllabusBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SyllabusFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var syllabusScreen :StudentMainScreenActivity
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
        var binding = FragmentSyllabusBinding.inflate(layoutInflater,container,false)

        syllabusScreen = activity as StudentMainScreenActivity
        binding.btSem1.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","1")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }
        binding.btSem2.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","2")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }
        binding.btSem3.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","3")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }
        binding.btSem4.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","4")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }
        binding.btSem5.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","5")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }
        binding.btSem6.setOnClickListener {
            var bundle= Bundle()
            bundle.putString("tog","6")
            syllabusScreen.navController.navigate(R.id.firstSemFragment,bundle)
        }

        return binding.root
    }

}