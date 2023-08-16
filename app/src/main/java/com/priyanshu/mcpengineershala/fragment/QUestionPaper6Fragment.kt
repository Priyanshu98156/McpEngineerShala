package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQUestionPaper6Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QUestionPaper6Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quest6Screen :StudentMainScreenActivity
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
        var binding = FragmentQUestionPaper6Binding.inflate(layoutInflater,container,false)
        quest6Screen = activity as StudentMainScreenActivity
        binding.cvAda.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Ada")
            quest6Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)

        }
        binding.cvAdw.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Adw")
            quest6Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvCc.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cc")
            quest6Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvCpp.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cpp")
            quest6Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }



        return binding.root
    }

}