package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.StudentMainScreenActivity
import com.priyanshu.mcpengineershala.databinding.FragmentShowQuestionPaperBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ShowQuestionPaperFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var subject: String? = null
    private var param2: String? = null
    lateinit var showQuestScreen: StudentMainScreenActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this
        var binding = FragmentShowQuestionPaperBinding.inflate(layoutInflater, container, false)

        showQuestScreen = activity as StudentMainScreenActivity

        arguments?.let {
            subject = it.getString("subject")
        }
        if (subject == "Physics-1") {
            binding.pdfView.fromAsset("PHY 1.pdf").load()
        } else if (subject == "Cfit") {
            binding.pdfView.fromAsset("CFIT.pdf").load()
        } else if (subject == "Chemistry") {
            binding.pdfView.fromAsset("CHEM.pdf").load()
        } else if (subject == "Eng-1") {
            binding.pdfView.fromAsset("English 1.pdf").load()
        } else if (subject == "Maths-1") {
            binding.pdfView.fromAsset("Maths 1.pdf").load()
        } else if (subject == "Drawing") {
            binding.pdfView.fromAsset("Drawing.pdf").load()
        } else if (subject == "Maths-2") {
            binding.pdfView.fromAsset("Maths 2.pdf").load()
        } else if (subject == "Physics-2") {
            binding.pdfView.fromAsset("PHY 2.pdf").load()
        } else if (subject == "English-2") {
            binding.pdfView.fromAsset("English 2.pdf").load()
        } else if (subject == "Bex") {
            binding.pdfView.fromAsset("BasicElectronics.pdf").load()
        } else if (subject == "Evs") {
            binding.pdfView.fromAsset("EVS.pdf").load()
        } else if (subject == "Os") {
            binding.pdfView.fromAsset("OS.pdf").load()
        } else if (subject == "De") {
            binding.pdfView.fromAsset("DE.pdf").load()
        } else if (subject == "Iwt") {
            binding.pdfView.fromAsset("IWT.pdf").load()
        } else if (subject == "Se") {
            binding.pdfView.fromAsset("SE.pdf").load()
        } else if (subject == "Cpuc") {
            binding.pdfView.fromAsset("CPUC.pdf").load()
        } else if (subject == "MM") {
            binding.pdfView.fromAsset("MM.pdf").load()
        } else if (subject == "Cns") {
            binding.pdfView.fromAsset("CNS.pdf").load()
        } else if (subject == "Gsed") {
            binding.pdfView.fromAsset("GSED.pdf").load()
        } else if (subject == "Dsa") {
            binding.pdfView.fromAsset("DSA.pdf").load()
        } else if (subject == "Java") {
            binding.pdfView.fromAsset("Java.pdf").load()
        } else if (subject == "Ca") {
            binding.pdfView.fromAsset("CA.pdf").load()
        } else if (subject == "Dbms") {
            binding.pdfView.fromAsset("DBMS.pdf").load()
        } else if (subject == "Bom") {
            binding.pdfView.fromAsset("BOM.pdf").load()
        } else if (subject == "Cpi") {
            binding.pdfView.fromAsset("CPI.pdf").load()
        } else if (subject == "Wd") {
            binding.pdfView.fromAsset("WDP.pdf").load()
        } else if (subject == "Mp") {
            binding.pdfView.fromAsset("MP.pdf").load()
        } else if (subject == "Adw") {
            binding.pdfView.fromAsset("ADW.pdf").load()
        } else if (subject == "Ada") {
            binding.pdfView.fromAsset("ADA.pdf").load()
        } else if (subject == "Cc") {
            binding.pdfView.fromAsset("CC.pdf").load()
        } else if (subject == "Cpp") {
            binding.pdfView.fromAsset("CPP.pdf").load()
        } else {
            Toast.makeText(showQuestScreen, "Nhi hoya bhai", Toast.LENGTH_SHORT).show()
        }




        return binding.root
    }

}