package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickAnnouncement
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.AnnouncementAdapter
import com.priyanshu.mcpengineershala.adapter.TeacherListAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentAnnouncementFragementBinding
import com.priyanshu.mcpengineershala.dataclasses.Announcement
import com.priyanshu.mcpengineershala.dataclasses.Registration
import com.priyanshu.mcpengineershala.dataclasses.Teachers

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class announcement_fragement : Fragment(), OnUserClickAnnouncement {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var announcementList: ArrayList<Announcement>
    lateinit var announcementAdapter: AnnouncementAdapter
    lateinit var announcementScreen: StudentMainScreenActivity


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
        var binding = FragmentAnnouncementFragementBinding.inflate(layoutInflater, container, false)
        announcementScreen = activity as StudentMainScreenActivity
        announcementList = ArrayList()
        var uid:String = ""

        var currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null){
            uid = currentUser.uid
        }
        var testing:String? =""

        arguments?.let {
            testing = it.getString("dept")
        }
        println("===========================================announcementFragment"+testing)
        FirebaseDatabase.getInstance().reference.child("Announcement")
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (each in snapshot.children) {
                        var data = each.getValue(Announcement::class.java)
                        if ((data != null && data.dept == testing) || (data != null && data.dept == "Admin") ) {
                            println(data)
                            announcementList.add(data)
                        }
                        announcementAdapter = AnnouncementAdapter(
                            announcementScreen,
                            announcementList,
                            this@announcement_fragement
                        )
                        binding.rvAnnouncement.layoutManager =
                            LinearLayoutManager(announcementScreen)
                        binding.rvAnnouncement.adapter = announcementAdapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


        return binding.root
    }

    override fun onUserAnnouncement(announce: Announcement) {
        println("userData $announce")
        var bundle = Bundle()
        bundle.putString("title", announce.title)
        bundle.putString("description", announce.description)
        bundle.putString("imageUrl", announce.imageUri)

        announcementScreen.navController.navigate(R.id.showAnnouncementFragment, bundle)
    }

}