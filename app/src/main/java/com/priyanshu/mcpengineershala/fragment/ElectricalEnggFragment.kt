package com.priyanshu.mcpengineershala.fragment

import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.priyanshu.mcpengineershala.R
import com.priyanshu.mcpengineershala.databinding.FragmentElectricalEnggBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ElectricalEnggFragment : Fragment() {
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
        var binding = FragmentElectricalEnggBinding.inflate(layoutInflater,container,false)
        binding.tvIntro.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.BOLD)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)
            binding.tvFacilities.setTypeface(null, Typeface.NORMAL)
            binding.tvCareerAndJob.setTypeface(null, Typeface.NORMAL)
            binding.tvIntroPara.visibility = View.VISIBLE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvMissionPara.visibility = View.GONE;
            binding.tvFacilitiesPara.visibility = View.GONE;
            binding.tvCareerAndJobPara.visibility = View.GONE;
        }
        binding.tvVision.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.BOLD)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)
            binding.tvFacilities.setTypeface(null, Typeface.NORMAL)
            binding.tvCareerAndJob.setTypeface(null, Typeface.NORMAL)
            binding.tvVisionPara.visibility = View.VISIBLE;
            binding.tvIntroPara.visibility = View.GONE;
            binding.tvMissionPara.visibility = View.GONE;
            binding.tvFacilitiesPara.visibility = View.GONE;
            binding.tvCareerAndJobPara.visibility = View.GONE;
        }
        binding.tvMission.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.BOLD)
            binding.tvFacilities.setTypeface(null, Typeface.NORMAL)
            binding.tvCareerAndJob.setTypeface(null, Typeface.NORMAL)
            binding.tvMissionPara.visibility = View.VISIBLE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvIntroPara.visibility = View.GONE;
            binding.tvFacilitiesPara.visibility = View.GONE;
            binding.tvCareerAndJobPara.visibility = View.GONE;
        }
        binding.tvFacilities.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)
            binding.tvFacilities.setTypeface(null, Typeface.BOLD)
            binding.tvCareerAndJob.setTypeface(null, Typeface.NORMAL)
            binding.tvFacilitiesPara.visibility = View.VISIBLE;
            binding.tvMissionPara.visibility = View.GONE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvIntroPara.visibility = View.GONE;
            binding.tvCareerAndJobPara.visibility = View.GONE;
        }
        binding.tvCareerAndJob.setOnClickListener {
            binding.tvIntro.setTypeface(null, Typeface.NORMAL)
            binding.tvVision.setTypeface(null, Typeface.NORMAL)
            binding.tvMission.setTypeface(null, Typeface.NORMAL)
            binding.tvFacilities.setTypeface(null, Typeface.NORMAL)
            binding.tvCareerAndJob.setTypeface(null, Typeface.BOLD)
            binding.tvCareerAndJobPara.visibility = View.VISIBLE;
            binding.tvFacilitiesPara.visibility = View.GONE;
            binding.tvMissionPara.visibility = View.GONE;
            binding.tvVisionPara.visibility = View.GONE;
            binding.tvIntroPara.visibility = View.GONE;

        }
        return binding.root
    }

}