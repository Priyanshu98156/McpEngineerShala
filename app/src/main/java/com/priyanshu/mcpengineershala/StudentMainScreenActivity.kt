package com.priyanshu.mcpengineershala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.priyanshu.mcpengineershala.databinding.ActivityStudentMainScreenBinding

class StudentMainScreenActivity : AppCompatActivity() {
    lateinit var binding :ActivityStudentMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}