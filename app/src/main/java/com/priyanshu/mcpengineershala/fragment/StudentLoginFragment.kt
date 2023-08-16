package com.priyanshu.mcpengineershala.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentStudentLoginBinding
import com.priyanshu.mcpengineershala.helper.SharedPreferencesHelper
import kotlin.math.log

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StudentLoginFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var param1: String? = null
    private var param2: String? = null


    lateinit var firebaseAuth: FirebaseAuth
    lateinit var logInScreen: Home_screen_activity

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

        var binding = FragmentStudentLoginBinding.inflate(layoutInflater, container, false)
        logInScreen = activity as Home_screen_activity
        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginbutton.setOnClickListener {
            if (binding.Username.text.toString().isNullOrEmpty()) {
                binding.Username.error = "Enter email"
            } else if (binding.Password.text.toString().isNullOrEmpty()) {
                binding.Password.error = "Enter password"
            } else {
                firebaseAuth.signInWithEmailAndPassword(
                    binding.Username.text.toString(),
                    binding.Password.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        var intent = Intent(logInScreen, StudentMainScreenActivity::class.java)
                        startActivity(intent)
                        logInScreen.finish()

                    } else {
                        Toast.makeText(logInScreen, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

        }
        binding.frgtpswrd.setOnClickListener {
            if (binding.Username.text.toString().isNullOrEmpty()) {
                binding.Username.error = "Enter email "
            } else {
                firebaseAuth.sendPasswordResetEmail(binding.Username.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(
                                logInScreen,
                                "An Email has been sent on your email-id",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                logInScreen,
                                "Please Check Your Internet Connection or Check your Entered Email Entered",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
        return binding.root
    }

//    override fun onStart() {
//        logInScreen = activity as Home_screen_activity
//        super.onStart()
//        var user = FirebaseAuth.getInstance().currentUser
//        if (user!=null){
//            logInScreen.navController.navigate(R.id.studentHomeFragment)
//        }
//    }


}