package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentFirstSemBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FirstSemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var pdfview: PDFView
    private lateinit var webView: WebView


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

        var binding = FragmentFirstSemBinding.inflate(layoutInflater,container,false)
        arguments?.let {
            param1 = it.getString("tog")
        }
       pdfview = binding.pdfView
        if (param1 == "1"){
        pdfview.fromAsset("sem-1.pdf").load()}
        else if (param1 == "2"){
            pdfview.fromAsset("sem-2.pdf").load()
        }
        else if (param1 == "3"){
            pdfview.fromAsset("sem-3.pdf").load()
        }
        else if (param1 == "4"){
            pdfview.fromAsset("sem-4.pdf").load()
        }
        else if (param1 == "5"){
            pdfview.fromAsset("sem-5.pdf").load()
        }
        else {
            pdfview.fromAsset("sem-6.pdf").load()
        }

        return binding.root
    }

}