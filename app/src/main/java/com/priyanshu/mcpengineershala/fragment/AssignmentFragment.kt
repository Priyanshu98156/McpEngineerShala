package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickAssignment
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.AnnouncementAdapter
import com.priyanshu.mcpengineershala.adapter.AssignmentAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentAssignmentBinding
import com.priyanshu.mcpengineershala.dataclasses.Announcement
import com.priyanshu.mcpengineershala.dataclasses.Assignment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AssignmentFragment : Fragment(),OnUserClickAssignment {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var sem: String? = null
    lateinit var assignmentScreen:StudentMainScreenActivity
    lateinit var assignmentList: ArrayList<Assignment>
    lateinit var assignmentAdapter: AssignmentAdapter
    var dept:String?= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentAssignmentBinding.inflate(layoutInflater,container,false)
        assignmentScreen = activity as StudentMainScreenActivity
        assignmentList = ArrayList()
        arguments?.let {
            dept = it.getString("dept")
            sem = it.getString("sem")
        }
        FirebaseDatabase.getInstance().reference.child("Assignment")
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (each in snapshot.children) {
                        var data = each.getValue(Assignment::class.java)
                        if (data != null && data.dept == dept && data.semester == sem) {
                            println(data)
                            assignmentList.add(data)
                        }
                        assignmentAdapter = AssignmentAdapter(
                            assignmentScreen,
                            assignmentList,
                            this@AssignmentFragment
                        )
                        binding.rvAssignment.layoutManager =
                            LinearLayoutManager(assignmentScreen)
                        binding.rvAssignment.adapter = assignmentAdapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


        return binding.root
    }

    override fun onUserAssignment(assignment: Assignment) {
        var bundle = Bundle()
        bundle.putString("subject",assignment.subject)
        bundle.putString("url",assignment.imageUrl)
        println(assignment.imageUrl)
        assignmentScreen.navController.navigate(R.id.showAssignmentFragment,bundle)
    }

}