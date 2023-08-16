package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaperBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuestionPaperFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var questionPaperScreen:StudentMainScreenActivity

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
        var binding = FragmentQuestionPaperBinding.inflate(layoutInflater,container,false)
        questionPaperScreen = activity as StudentMainScreenActivity
        binding.cvSem1.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.questionPaper1Fragment)
        }
        binding.cvSem2.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.questionPaper2Fragment)

        }
        binding.cvSem3.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.questionPaper3Fragment)

        }
        binding.cvSem4.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.questionPaper4Fragment)
        }
        binding.cvSem5.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.questionPaper5Fragment)

        }
        binding.cvSem6.setOnClickListener {
            questionPaperScreen.navController.navigate(R.id.QUestionPaper6Fragment)

        }
        return binding.root
    }

}