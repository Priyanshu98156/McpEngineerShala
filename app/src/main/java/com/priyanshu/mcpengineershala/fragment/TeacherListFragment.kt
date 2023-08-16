package com.priyanshu.mcpengineershala.fragment

import android.content.Intent
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
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClick
import com.priyanshu.mcpengineershala.ChatActivity
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.TeacherListAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentTeacherListBinding
import com.priyanshu.mcpengineershala.dataclasses.Teachers


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TeacherListFragment : Fragment(), OnUserClick {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var teacherListScreen:StudentMainScreenActivity
    lateinit var studentList :ArrayList<Teachers>
    lateinit var teacherListAdapter:TeacherListAdapter

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
        var binding  = FragmentTeacherListBinding.inflate(layoutInflater,container,false)
        teacherListScreen = activity as StudentMainScreenActivity
        studentList = ArrayList()
        FirebaseDatabase.getInstance().reference.child("Teachers").addValueEventListener(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for(each in snapshot.children){
                    var data = each.getValue(Teachers::class.java)
                    if(data!=null) {
                        println(data)
                        studentList.add(data)
                    }
                    teacherListAdapter= TeacherListAdapter(teacherListScreen,studentList,this@TeacherListFragment)
                    binding.rvStudentList.layoutManager= LinearLayoutManager(teacherListScreen)
                    binding.rvStudentList.adapter = teacherListAdapter
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
        return binding.root

    }
    override fun onUser(teacher: Teachers) {
       var intent = Intent(teacherListScreen,ChatActivity::class.java)
        intent.putExtra("name",teacher.teacher_name)
        intent.putExtra("email",teacher.teacher_Email)
        intent.putExtra("uid",teacher.teacher_uid)
        intent.putExtra("senderId",teacherListScreen.user.toString())
        startActivity(intent)
    }


}