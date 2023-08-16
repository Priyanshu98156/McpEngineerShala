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
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.AnnouncementAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentTimeTableBinding
import com.priyanshu.mcpengineershala.dataclasses.Announcement
import com.priyanshu.mcpengineershala.dataclasses.TimeTable
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TimeTableFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var url: String? = null
    lateinit var timeTableList :ArrayList<TimeTable>
    lateinit var timeTableScreen :StudentMainScreenActivity

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
        // Inflate the layout for this fragment
        var binding = FragmentTimeTableBinding.inflate(layoutInflater,container,false)
        timeTableList = ArrayList()
        timeTableScreen = StudentMainScreenActivity()
        FirebaseDatabase.getInstance().reference.child("TimeTable")
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (each in snapshot.children) {
                        var data = each.getValue(TimeTable::class.java)
                        if (data != null) {
                            println(data)
                            timeTableList.add(data)
                            url = data.imageUri
                            Picasso.get().load(url).into(binding.ivTimeTable)
                            binding.progressBar.visibility = View.GONE
                            break
                        }
                         }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        println(url)





        return binding.root
    }

}