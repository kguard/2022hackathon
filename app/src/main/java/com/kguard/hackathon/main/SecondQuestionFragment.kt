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
import com.kguard.hackathon.databinding.FragmentSecondQuestionBinding


class SecondQuestionFragment : Fragment() {
    private lateinit var binding: FragmentSecondQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_second_question,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var correct:Boolean=false
        binding.tvSecondAnswer1.setOnClickListener {
            correct=true
        }
        binding.tvSecondAnswer2.setOnClickListener {
            correct=false
        }
        binding.tvSecondAnswer3.setOnClickListener {
            correct=false
        }
        binding.btConfirm2.setOnClickListener {
            binding.btNext1.visibility=View.VISIBLE
            binding.btStop2.visibility=View.VISIBLE
            binding.btConfirm2.visibility=View.INVISIBLE
            if(!correct)
            {
                binding.ivSecondIncorrect.visibility=View.VISIBLE
                binding.imageView9.visibility=View.INVISIBLE
                binding.tvSecondred.visibility=View.VISIBLE
                binding.tvSecondred2.visibility=View.VISIBLE
            }
            else if(correct)
            {
                binding.ivSecondCorrect.visibility=View.VISIBLE
            }
        }
        binding.btStop2.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}