package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentShowAnnouncementBinding
import com.squareup.picasso.Picasso

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShowAnnouncementFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var title: String? = null
    var description: String? = null
    var imageUrl: String? = null

    private var param1: String? = null
    private var param2: String? = null

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
        var binding = FragmentShowAnnouncementBinding.inflate(layoutInflater,container,false)
        arguments?.let {
            title = it.getString("title")
            description = it.getString("description")
            imageUrl = it.getString("imageUrl")
        }
        println(imageUrl)
        println(title)
        binding.tvTitle.text = title
        Picasso.get().load(imageUrl).into(binding.ivAnnounce)
        binding.details.setOnClickListener {
            binding.tvDescription.text=description
            binding.tvDescription.visibility = View.VISIBLE


        }
        return binding.root
    }

}