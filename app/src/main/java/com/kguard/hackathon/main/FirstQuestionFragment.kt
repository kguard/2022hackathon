package com.kguard.hackathon.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentFirstQuestionBinding

class FirstQuestionFragment : Fragment() {
    private lateinit var binding : FragmentFirstQuestionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_first_question,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var correct:Boolean=false
        binding.tvFirstQuizAnswer1.setOnClickListener {
            correct=false
        }
        binding.tvFirstQuizAnswer2.setOnClickListener {
            correct=false
        }
        binding.tvFirstQuizAnswer3.setOnClickListener {
            correct=false
        }
        binding.tvFirstQuizAnswer4.setOnClickListener {
            correct=true
        }
        binding.btConfirm1.setOnClickListener {
            binding.btNext.visibility=View.VISIBLE
            binding.btStop.visibility=View.VISIBLE
            binding.btConfirm1.visibility=View.INVISIBLE
            if(!correct)
            {
                binding.ivFirstIncorrect.visibility=View.VISIBLE
                binding.imageView10.visibility=View.INVISIBLE
                binding.tvFirstred.visibility=View.VISIBLE
            }
            else if(correct)
            {
                binding.ivFirstCorrect.visibility=View.VISIBLE
            }
        }
        binding.btNext.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager)?.currentItem=1
        }
        binding.btStop.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}