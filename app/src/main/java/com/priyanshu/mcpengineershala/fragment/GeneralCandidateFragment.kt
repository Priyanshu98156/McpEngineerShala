package com.priyanshu.mcpengineershala.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentFeeStructureFragmentBinding
import com.priyanshu.mcpengineershala.databinding.FragmentGeneralCandidateBinding


class GeneralCandidateFragment : Fragment() {
    lateinit var binding: FragmentGeneralCandidateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentGeneralCandidateBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}