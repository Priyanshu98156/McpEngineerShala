package com.priyanshu.mcpengineershala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.priyanshu.mcpengineershala.databinding.ActivityFeeStructureBinding
import com.priyanshu.mcpengineershala.databinding.FragmentFeeStructureFragmentBinding

class FeeStructureActivity : AppCompatActivity() {
    lateinit var binding: ActivityFeeStructureBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeeStructureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController=findNavController(R.id.navController)
        binding.tvHome.setOnClickListener {
            var intent  = Intent(this,Home_screen_activity::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvGeneral.setOnClickListener {
            navController.navigate(R.id.generalCandidateFragment)
        }
        binding.tvSc.setOnClickListener {
            navController.navigate(R.id.scCandidateFragment)
        }
        binding.tvStudent.setOnClickListener {
            navController.navigate(R.id.studentActivitiesFragment)
        }

    }
}