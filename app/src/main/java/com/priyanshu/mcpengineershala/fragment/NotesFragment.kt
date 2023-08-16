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
import com.priyanshu.mcpenggshalaadmin.Interface.OnUserClickNotes
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.adapter.NotesAdapter
import com.priyanshu.mcpengineershala.databinding.FragmentNotesBinding
import com.priyanshu.mcpengineershala.dataclasses.Notes

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "dept"


class NOtesFragment : Fragment() ,OnUserClickNotes{
    // TODO: Rename and change types of parameters
    private var sem: String? = null
    private var dept: String? = null
    lateinit var notesScreen :StudentMainScreenActivity
    lateinit var notesList: ArrayList<Notes>
    lateinit var notesAdapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentNotesBinding.inflate(layoutInflater,container,false)
        arguments?.let {
            sem = it.getString("sem")
            dept = it.getString("dept")
        }
        notesScreen = activity  as StudentMainScreenActivity
        notesList = ArrayList()

        FirebaseDatabase.getInstance().reference.child("Notes")
            .addValueEventListener(object :
                ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (each in snapshot.children) {
                        var data = each.getValue(Notes::class.java)
                        if (data != null && data.semester == sem && data.dept == dept) {
                            println(data)
                            notesList.add(data)
                        }
                        notesAdapter = NotesAdapter(
                            notesScreen,
                            notesList,
                            this@NOtesFragment
                        )
                        binding.rvNotes.layoutManager =
                            LinearLayoutManager(notesScreen)
                        binding.rvNotes.adapter = notesAdapter
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

        return binding.root
    }

    override fun onUserNotes(notes: Notes) {
        var bundle = Bundle()
        bundle.putString("subject",notes.subject)
        bundle.putString("url",notes.pdfUrl)
        notesScreen.navController.navigate(R.id.showNotesFragment,bundle)
    }

}