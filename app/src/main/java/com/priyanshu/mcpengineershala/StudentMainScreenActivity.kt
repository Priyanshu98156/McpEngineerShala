package com.priyanshu.mcpengineershala

import android.Manifest
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.oAuthCredential
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.priyanshu.mcpengineershala.databinding.ActivityStudentMainScreenBinding
import com.priyanshu.mcpengineershala.databinding.ForgetedittextBinding
import com.priyanshu.mcpengineershala.dataclasses.Registration
import com.priyanshu.mcpengineershala.dataclasses.StudentData
import java.util.concurrent.ThreadLocalRandom.current

class StudentMainScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivityStudentMainScreenBinding
    lateinit var navController: NavController
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    lateinit var studentList: ArrayList<Registration>
    var user: String = ""
    var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentList = ArrayList()
        navController = findNavController(R.id.navController)
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()

        var uid = auth.currentUser?.uid.toString()
        user = intent.getStringExtra("uid").toString()
        binding.apply {
            toggle = ActionBarDrawerToggle(
                this@StudentMainScreenActivity,
                drawerLayout12,
                R.string.open,
                R.string.close
            )
            drawerLayout12.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navVieww.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        navController.navigate(R.id.studentHomeFragment)

                    }
                    R.id.logout -> {
                        auth.signOut()
                        var intent =
                            Intent(this@StudentMainScreenActivity, Home_screen_activity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    R.id.changePassword -> {
                        database.reference.child("Students")
                            .addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(snapshot: DataSnapshot) {
                                    for (each in snapshot.children) {
                                        var data = each.getValue(Registration::class.java)
                                        if (data != null && data.uid == uid) {
                                            auth.sendPasswordResetEmail(data.email)
                                                .addOnCompleteListener {
                                                    if (it.isSuccessful) {
                                                        println("================================================"+data.email   )
                                                        Toast.makeText(
                                                            this@StudentMainScreenActivity,
                                                            "An Email has been sent on your email-id",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    } else {
                                                        Toast.makeText(
                                                            this@StudentMainScreenActivity,
                                                            "Please Check Your Internet Connection or Check your Entered Email Entered",
                                                            Toast.LENGTH_SHORT
                                                        ).show()
                                                    }
                                                }
                                            break
                                        }

                                    }
                                }


                                override fun onCancelled(error: DatabaseError) {
                                }

                            })

                    }

                    R.id.whatsapp -> {
                        val phoneNumber =
                            "6284056754" // replace with the phone number you want to send the message to
                        val message =
                            "Hello, this is a WhatsApp message!" // replace with the message you want to send
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data =
                            Uri.parse("https://wa.me/$phoneNumber/?text=${Uri.encode(message)}")
                        try {
                            startActivity(intent)
                        } catch (ex: ActivityNotFoundException) {
                            Toast.makeText(
                                this@StudentMainScreenActivity,
                                "Please install WhatsApp to send a message",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    R.id.message -> {
                        if (ContextCompat.checkSelfPermission(
                                this@StudentMainScreenActivity,
                                android.Manifest.permission.SEND_SMS
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@StudentMainScreenActivity,
                                arrayOf(android.Manifest.permission.SEND_SMS),
                                Home_screen_activity.MY_PERMISSIONS_REQUEST_SEND_SMS
                            )
                            checkPermissionCall()
                        } else {
                            val phoneNumber =
                                "9041175563"// Replace with the phone number you want to send the message to
                            val message =
                                "Hello, world!" // Replace with the message you want to send
                            val sendIntent = Intent(Intent.ACTION_VIEW)
                            sendIntent.data = Uri.parse("sms:$phoneNumber")
                            sendIntent.putExtra("sms_body", message)
                            startActivity(sendIntent)
                        }
                    }
                    R.id.call -> {
                        if (ContextCompat.checkSelfPermission(
                                this@StudentMainScreenActivity,
                                android.Manifest.permission.CALL_PHONE
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@StudentMainScreenActivity,
                                arrayOf(android.Manifest.permission.CALL_PHONE),
                                Home_screen_activity.MY_PERMISSIONS_REQUEST_CALL_PHONE

                            )
                            checkPermissionCall()
                        } else {
                            val phoneNumber = "9888168884"
                            val callIntent =
                                Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
                            startActivity(callIntent)

                        }
                    }
                }
                true
            }
        }


    }

    fun checkPermissionCall() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CALL_PHONE),
                1
            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            true
        }
        return super.onOptionsItemSelected(item)


    }

}
