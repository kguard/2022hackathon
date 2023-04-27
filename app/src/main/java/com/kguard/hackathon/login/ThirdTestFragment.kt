package com.kguard.hackathon.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.kguard.hackathon.MainActivity
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentThirdTestBinding


class ThirdTestFragment : Fragment() {
    private lateinit var binding: FragmentThirdTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_third_test,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btNexttext3.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_characterFragment)
        }
        binding.tvThirdAndswer1.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_characterFragment)
        }
        binding.tvThirdAnswer2.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_characterFragment)
        }
        binding.tvThirdAnswer3.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_characterFragment)
        }
        binding.tvThirdAnswer4.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_characterFragment)
        }

    }


}