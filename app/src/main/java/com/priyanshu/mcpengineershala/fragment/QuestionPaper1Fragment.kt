package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentQuestionPaper1Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QuestionPaper1Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var quesPaper1Screen:StudentMainScreenActivity
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
        var binding = FragmentQuestionPaper1Binding.inflate(layoutInflater,container,false)
        quesPaper1Screen = activity as StudentMainScreenActivity
        binding.cvPhysics.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Physics-1")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvCfit.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Cfit")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvChemistry.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Chemistry")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)}
        binding.cvEng.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Eng-1")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvMaths.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Maths-1")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }
        binding.cvDrawing.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("subject","Drawing")
            quesPaper1Screen.navController.navigate(R.id.showQuestionPaperFragment,bundle)
        }




        return binding.root
    }

}