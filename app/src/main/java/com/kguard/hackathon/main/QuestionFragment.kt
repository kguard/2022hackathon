package com.kguard.hackathon.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_question,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter=ViewpagerAdapter(requireActivity())
        binding.viewpager.isSaveEnabled=false
        binding.viewpager.isUserInputEnabled=false

    }
    private inner class ViewpagerAdapter(fa: FragmentActivity):FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when(position)
            {
                0-> FirstQuestionFragment()
                else-> SecondQuestionFragment()
            }
        }


    }


}