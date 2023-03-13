package com.priyanshu.mcpengineershala


import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.SEND_SMS
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.priyanshu.mcpengineershala.databinding.ActivityHomeScreenBinding

class Home_screen_activity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var binding: ActivityHomeScreenBinding
    lateinit var toggle: ActionBarDrawerToggle

    companion object {
        var MY_PERMISSIONS_REQUEST_SEND_SMS = 1
        var MY_PERMISSIONS_REQUEST_CALL_PHONE = 1

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.navController)
        binding.apply {
            toggle = ActionBarDrawerToggle(
                this@Home_screen_activity,
                drawerLayout,
                R.string.open,
                R.string.close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()


            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                            navController.navigate(R.id.home_fragment)

                        Toast.makeText(
                            this@Home_screen_activity,
                            "presssed 1 item",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    R.id.search -> {
                        Toast.makeText(
                            this@Home_screen_activity,
                            "presssed 2 item",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    R.id.login -> {
                        Toast.makeText(
                            this@Home_screen_activity,
                            "presssed 3 item",
                            Toast.LENGTH_SHORT
                        ).show()
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
                                this@Home_screen_activity,
                                "Please install WhatsApp to send a message",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    R.id.message -> {
                        if (ContextCompat.checkSelfPermission(
                                this@Home_screen_activity,
                                android.Manifest.permission.SEND_SMS
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@Home_screen_activity,
                                arrayOf(android.Manifest.permission.SEND_SMS),
                                MY_PERMISSIONS_REQUEST_SEND_SMS
                            )
                            checkPermission()
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
                                this@Home_screen_activity,
                                android.Manifest.permission.CALL_PHONE
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                this@Home_screen_activity,
                                arrayOf(android.Manifest.permission.CALL_PHONE),MY_PERMISSIONS_REQUEST_CALL_PHONE

                            )
                            checkPermissionCall()
                        } else {
                            val phoneNumber = "9815673234"
                            val callIntent =
                                Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
                            startActivity(callIntent)

                        }
                    }
                }
                true
            }
        }
        binding.menubar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeid -> {
                    navController.navigate(R.id.home_fragment)
                }
                R.id.explore -> {
                    navController.navigate(R.id.courses_fragment2)
                }
                R.id.about -> {
                    navController.navigate(R.id.about_us_fragment)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                SEND_SMS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.SEND_SMS),
                1
            )
        }
    }

    fun checkPermissionCall() {
        if (ActivityCompat.checkSelfPermission(
                this, CALL_PHONE
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