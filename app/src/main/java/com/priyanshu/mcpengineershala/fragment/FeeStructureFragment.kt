package com.priyanshu.mcpengineershala.fragment

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentFeeStructureBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class FeeStructureFragment : Fragment() {
    // TODO: Rename and change types of parameters
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

        var binding = FragmentFeeStructureBinding.inflate(layoutInflater,container,false)
        binding.tvGeneralCandidate.setOnClickListener {
            binding.tvGeneralCandidate.setTypeface(null,Typeface.BOLD)
            binding.tvScCandidate.setTypeface(null,Typeface.NORMAL)
            binding.tvStudentFund.setTypeface(null,Typeface.NORMAL)

            binding.tivGeneralCandidate.visibility = View.VISIBLE
            binding.tivScCandidate.visibility = View.GONE
            binding.tivStudentFund.visibility = View.GONE
        }
        binding.tvScCandidate.setOnClickListener {
            binding.tvGeneralCandidate.setTypeface(null,Typeface.NORMAL)
            binding.tvScCandidate.setTypeface(null,Typeface.BOLD)
            binding.tvStudentFund.setTypeface(null,Typeface.NORMAL)

            binding.tivGeneralCandidate.visibility = View.GONE
            binding.tivScCandidate.visibility = View.VISIBLE
            binding.tivStudentFund.visibility = View.GONE
        }
        binding.tvStudentFund.setOnClickListener {
            binding.tvGeneralCandidate.setTypeface(null,Typeface.NORMAL)
            binding.tvScCandidate.setTypeface(null,Typeface.NORMAL)
            binding.tvStudentFund.setTypeface(null,Typeface.BOLD)

            binding.tivGeneralCandidate.visibility = View.GONE
            binding.tivScCandidate.visibility = View.GONE
            binding.tivStudentFund.visibility = View.VISIBLE
        }


        return binding.root
    }

}