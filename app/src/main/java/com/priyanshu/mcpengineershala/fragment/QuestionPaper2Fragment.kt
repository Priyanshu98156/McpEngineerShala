package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaper2Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuestionPaper2Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quest2Screen:StudentMainScreenActivity
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
        // Inflate the layout for this fragment
        var binding = FragmentQuestionPaper2Binding.inflate(layoutInflater,container,false)
        quest2Screen = activity as StudentMainScreenActivity
        binding.cvEng.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","English-2")
            quest2Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvBe.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Bex")
            quest2Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvEvs.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Evs")
            quest2Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvMaths.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Maths-2")
            quest2Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvPhysics.setOnClickListener { var bundle = Bundle()
            bundle.putString("subject","Physics-2")
            quest2Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle) }

        return binding.root
    }

}