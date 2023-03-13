package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentCoursesFragmentBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class courses_fragment : Fragment() {
    lateinit var CourseScreen : Home_screen_activity
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        CourseScreen= activity as Home_screen_activity
        var binding = FragmentCoursesFragmentBinding.inflate(layoutInflater,container,false)
        binding.CompEngg.setOnClickListener {
           CourseScreen.navController.navigate(R.id.compEnggFragment)
        }
        binding.ElectricalEngg.setOnClickListener {
            CourseScreen.navController.navigate(R.id.ElectricalEnggFragment)
        }
        binding.MechEngg.setOnClickListener {
            CourseScreen.navController.navigate(R.id.MechnicalEnggFragment)
        }
        binding.CivilEngg.setOnClickListener {
            CourseScreen.navController.navigate(R.id.CivilEnggFragment)
        }
        binding.AutoEngg.setOnClickListener {
            CourseScreen.navController.navigate(R.id.AutomobileEnggFragment)
        }
        binding.Ece.setOnClickListener {
            CourseScreen.navController.navigate(R.id.ElectronicsAndCommFragment)
        }
        binding.Pharmacy.setOnClickListener {
            CourseScreen.navController.navigate(R.id.PharmacyFragment)
        }


        return binding.root
    }

}