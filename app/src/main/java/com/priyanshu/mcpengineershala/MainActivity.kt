package com.priyanshu.mcpengineershala

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.priyanshu.mcpengineershala.databinding.ActivityMainBinding
import com.priyanshu.mcpengineershala.helper.SharedPreferencesHelper


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
//        if (sharedPreferencesHelper.isLoggedIn()) {
//            var intent = Intent(this, StudentMainScreenActivity::class.java)
//            startActivity(intent)
//        }
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)


        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this,Home_screen_activity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }


//        else{
//            var intent = Intent(this,Home_screen_activity::class.java)
//            startActivity(intent)
//            finish()
//        }
    }
