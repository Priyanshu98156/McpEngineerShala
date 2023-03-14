package com.priyanshu.mcpengineershala.fragment

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
        binding.signUpTV.setOnClickListener {
            logInScreen.navController.navigate(R.id.signUpStudentFragment)
        }
        binding.buttonLogIn.setOnClickListener {
            if(binding.email.text.toString().isNullOrEmpty()){
                binding.email.error ="Enter email"
            }
            else if(binding.pass.text.toString().isNullOrEmpty()){
                binding.pass.error ="Enter password"
            }
            else {
                firebaseAuth.signInWithEmailAndPassword(binding.email.text.toString(),binding.pass.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        logInScreen.navController.navigate(R.id.StudentHomeFragment)
                        val intent = Intent(logInScreen,StudentMainScreenActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(logInScreen, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
        return binding.root
    }

}