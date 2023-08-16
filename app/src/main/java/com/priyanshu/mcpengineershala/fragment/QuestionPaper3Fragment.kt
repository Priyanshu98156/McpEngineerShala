package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaper3Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuestionPaper3Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quest3Screen : StudentMainScreenActivity
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
        var binding = FragmentQuestionPaper3Binding.inflate(layoutInflater,container,false)
        quest3Screen = activity as StudentMainScreenActivity
        binding.cvDe.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","De")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }
        binding.cvCpuc.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cpuc")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvIwt.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Iwt")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }
        binding.cvOs.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Os")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }
        binding.cvMM.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","MM")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }
        binding.cvSe.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Se")
            quest3Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }


        return binding.root
    }

}