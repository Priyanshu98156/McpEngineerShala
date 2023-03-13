package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentSignUpStudentBinding
import com.priyanshu.mcpengineershala.dataclasses.StudentData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SignUpStudentFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var logInScreen: Home_screen_activity

    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var studentReference: DatabaseReference = database.getReference("Students")

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

        var binding = FragmentSignUpStudentBinding.inflate(layoutInflater, container, false)
        logInScreen = activity as Home_screen_activity
        firebaseAuth = FirebaseAuth.getInstance()
        binding.buttonSignUp.setOnClickListener {
            if (binding.emailTF.text.toString().isNullOrEmpty()) {
                binding.emailTF.error = "Enter e-mail"
            } else if (binding.nameTF.toString().isNullOrEmpty()) {
                binding.nameTF.error = "Enter name"
            } else if (binding.phoneTF.text.toString().isNullOrEmpty()) {
                binding.phoneTF.error = "Enter Phone Number"
            } else if (binding.deptTF.text.toString().isNullOrEmpty()) {
                binding.deptTF.error = "Enter Phone Number"
            } else if (binding.registrationNoTF.text.toString().isNullOrEmpty()) {
                binding.registrationNoTF.error = "Enter Phone Number"
            } else if (binding.passTF.text.toString().isNullOrEmpty()) {
                binding.passTF.error = "Enter Password"
            } else if (binding.conPassTF.text.toString().isNullOrEmpty()) {
                binding.conPassTF.error = "Enter Password"
            } else if (binding.passTF.text.toString() != binding.conPassTF.text.toString()) {
                binding.conPassTF.error = "Password not Same"
            } else {
                firebaseAuth.createUserWithEmailAndPassword(
                    binding.emailTF.text.toString(),
                    binding.passTF.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        var studentData = StudentData(
                            binding.nameTF.text.toString(),
                            binding.deptTF.text.toString(),
                            binding.registrationNoTF.text.toString(),
                            binding.phoneTF.text.toString(),
                            firebaseAuth.currentUser?.uid.toString()
                        )
                        Toast.makeText(logInScreen, "chl reha", Toast.LENGTH_SHORT)
                        studentReference.child(firebaseAuth.currentUser?.uid.toString())
                            .setValue(studentData)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(
                                        logInScreen,
                                        "Student data uploaded ",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    Toast.makeText(
                                        logInScreen,
                                        task.exception.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    } else {
                        Toast.makeText(logInScreen, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
        return binding.root
    }

}