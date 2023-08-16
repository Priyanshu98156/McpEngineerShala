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
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickMst
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.MstAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentMstBinding
import com.priyanshu.mcpengineershala.dataclasses.MstRecord

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MstFragment : Fragment(),OnUserClickMst {
    // TODO: Rename and change types of parameters
    var dept: String? = null
    private var sem: String? = null
    lateinit var mstScreen:StudentMainScreenActivity
    lateinit var mstList: ArrayList<MstRecord>
    lateinit var mstAdapter: MstAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var binding = FragmentMstBinding.inflate(layoutInflater,container,false)
        arguments?.let {
            dept = it.getString("dept")
            sem = it.getString("sem")
        }
        mstScreen = activity as StudentMainScreenActivity
        mstList = ArrayList()
        println("================================================================$sem")
        println("================================================================$dept")

        FirebaseDatabase.getInstance().reference.child("Mst")
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (each in snapshot.children) {
                        var data = each.getValue(MstRecord::class.java)
                        if (data != null && data.dept == dept && data.semester == sem) {
                            println(data)
                            mstList.add(data)
                        }
                        mstAdapter = MstAdapter(
                            mstScreen,
                            mstList,
                            this@MstFragment
                        )
                        binding.rvMst.layoutManager =
                            LinearLayoutManager(mstScreen)
                        binding.rvMst.adapter = mstAdapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        return binding.root
    }
    override fun onUserMst (mstRecord: MstRecord){
        var bundle = Bundle()
        bundle.putString("subject",mstRecord.title)
        bundle.putString("title",mstRecord.title)
        bundle.putString("date",mstRecord.title)
        bundle.putString("time",mstRecord.title)
        bundle.putString("url",mstRecord.pdfUrl)
        mstScreen.navController.navigate(R.id.showMstRecordFragment,bundle)

    }

}