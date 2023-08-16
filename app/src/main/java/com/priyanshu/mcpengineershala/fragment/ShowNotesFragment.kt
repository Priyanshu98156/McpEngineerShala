package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentShowAnnouncementBinding
import com.priyanshu.mcpengineershala.databinding.FragmentShowNotesBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ShowNotesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var subject: String? = ""
    private var pdfUrl: String? = null



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
        var binding = FragmentShowNotesBinding.inflate(layoutInflater,container,false)
        arguments?.let {
            subject = it.getString("title")
            pdfUrl = it.getString("url")
        }
        CoroutineScope(Dispatchers.IO).launch {
            val pdfStream = URL(pdfUrl).openStream()

            withContext(Dispatchers.Main) {
                binding.pdfView.fromStream(pdfStream).load()
            }
        }






        return binding.root
    }

}