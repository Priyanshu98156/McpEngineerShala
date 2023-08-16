package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaper5Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class QuestionPaper5Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quest5Screen :StudentMainScreenActivity
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
        var binding = FragmentQuestionPaper5Binding.inflate(layoutInflater,container,false)
        quest5Screen = activity as StudentMainScreenActivity
        binding.cvBom.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Bom")
            quest5Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvCpi.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cpi")
            quest5Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvMP.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Mp")
            quest5Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvWD.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Wd")
            quest5Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }


        return binding.root
    }

}