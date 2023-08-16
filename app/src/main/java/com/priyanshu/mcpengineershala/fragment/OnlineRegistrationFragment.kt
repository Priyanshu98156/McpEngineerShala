package com.priyanshu.mcpengineershala.fragment

import android.app.DatePickerDialog
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.priyanshu.mcpengineershala.Home_screen_activity
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentOnlineRegistrationBinding
import com.priyanshu.mcpengineershala.dataclasses.Registration
import papaya.`in`.sendmail.SendMail
import java.text.SimpleDateFormat
import java.util.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class OnlineRegistrationFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var binding: FragmentOnlineRegistrationBinding
    lateinit var homeScreen: Home_screen_activity

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
        binding = FragmentOnlineRegistrationBinding.inflate(layoutInflater, container, false)
        homeScreen = activity as Home_screen_activity
        var birthDate = ""
        var formattedDate = ""
        binding.btnDob.setOnClickListener {
            val currentDate = Calendar.getInstance()
            val year = currentDate.get(Calendar.YEAR)
            val month = currentDate.get(Calendar.MONTH)
            val day = currentDate.get(Calendar.DAY_OF_MONTH)

            // Create a date picker dialog
            val datePickerDialog = DatePickerDialog(
                homeScreen,
                { _, yearSelected, monthOfYear, dayOfMonth ->
                    // Format selected date as string
                    val calendar = Calendar.getInstance()
                    calendar.set(yearSelected, monthOfYear, dayOfMonth)
                    val dateFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault())
                    val selectedDate = dateFormat.format(calendar.time)

                    // Set selected date as text on EditText
                    binding.dob.setText(selectedDate)
                },
                year,
                month,
                day
            )

            // Show the date picker dialog
            datePickerDialog.show()
        }
        binding.rgQualification.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == binding.rbplus2.id) {
                binding.subjects.visibility = View.VISIBLE
                binding.rgSubjects.visibility = View.VISIBLE
            } else {
                binding.subjects.visibility = View.GONE
                binding.rgSubjects.visibility = View.GONE
            }
        }
        binding.btnSubmit.setOnClickListener {
            if (binding.email.text.toString().isEmpty()) {
                binding.email.error = "Cannot be empty"
            } else if (binding.name.text.toString().isEmpty()) {
                binding.name.error = "Cannot be empty"
            } else if (binding.phone.text.toString().isEmpty()) {
                binding.phone.error = "Cannot be empty"
            } else if (binding.discipline.text.toString().isEmpty()) {
                binding.discipline.error = "Cannot be empty"
            } else if (binding.dob.text.toString().isEmpty()) {
                binding.dob.error = "Cannot be empty"
            } else if (!binding.rbMatric.isChecked && !binding.rbplus1.isChecked && !binding.rbplus2.isChecked && !binding.rbIti.isChecked) {
                Toast.makeText(homeScreen, "Select Qualification", Toast.LENGTH_SHORT).show()
            }
            else if (!binding.rbGeneral.isChecked && !binding.rbSC.isChecked && !binding.rbBC.isChecked) {
                Toast.makeText(homeScreen, "Select Category ", Toast.LENGTH_SHORT).show()
            } else {
                var regId = FirebaseDatabase.getInstance().reference.child("Registration")
                    .push().key.toString()
                var category = ""
                if (binding.rbGeneral.isChecked)
                    category = "General"
                else if (binding.rbSC.isChecked)
                    category = "SC/St"
                else if (binding.rbBC.isChecked)
                    category = "BC/OBC"
                var qualification = ""
                if (binding.rbMatric.isChecked)
                    qualification = "Matric"
                else if (binding.rbplus1.isChecked)
                    qualification = "+1"
                else if (binding.rbplus2.isChecked)
                    qualification = "+2"
                else if (binding.rbIti.isChecked)
                    qualification = "ITI"

                if (qualification == "+2"){
                   if (binding.rbVocational.isChecked){
                        qualification = "Commerce"
                    }
                    else if (binding.rbScience.isChecked){
                        qualification ="Science"
                    }
                }
                var registration = Registration(
                    binding.name.text.toString(),
                    binding.email.text.toString(),
                    binding.phone.text.toString(),
                    binding.discipline.text.toString(),
                    category,
                    qualification,
                    binding.dob.text.toString(),regId,"",""
                )
                FirebaseDatabase.getInstance().reference.child("Registration").child(regId)
                    .setValue(registration).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            var password = binding.dob.text.toString().replace(" ", "")
                            Toast.makeText(
                                homeScreen,
                                "Your data have been Uploaded",
                                Toast.LENGTH_SHORT
                            ).show()

                            val mail = SendMail(
                                "mcpengshala@gmail.com", "lhyxtqnopdgdwgeg",
                                binding.email.text.toString(),
                                "Registration Conformation",
                                "As your Registration phase has been completed now you have to come to college for filling the admission charges within 30 days    "

                            )
                            mail.execute()

                            Toast.makeText(
                                homeScreen,
                                "Your id and password will be sent on your registered Email when your Admission phase will be completed",
                                Toast.LENGTH_SHORT
                            ).show()
                            homeScreen.navController.navigate(R.id.home_fragment)

                        }

                    }
            }

        }




        return binding.root
    }

    override fun onResume() {
        super.onResume()
        var districts = resources.getStringArray(R.array.Discipline)
        arrayAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, districts)
        binding.discipline.setAdapter(arrayAdapter)
    }
}