package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaper4Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuestionPaper4Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quest4Screen :StudentMainScreenActivity
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
        var binding = FragmentQuestionPaper4Binding.inflate(layoutInflater,container,false)
        quest4Screen = activity as StudentMainScreenActivity
        binding.cvCa.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Ca")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvCns.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cns")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvDSA.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Dsa")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvDbms.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Dbms")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvGsed.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Gsed")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)}
        binding.cvJava.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Java")
            quest4Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }

        return binding.root
    }

}