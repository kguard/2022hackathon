package com.kguard.hackathon.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentTestBinding
import com.kguard.hackathon.main.FirstQuestionFragment
import com.kguard.hackathon.main.SecondQuestionFragment


class TestFragment : Fragment() {
    private lateinit var binding:FragmentTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_test,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager2.adapter=ViewpagerAdapter(requireActivity())
        binding.viewpager2.isSaveEnabled=false
        binding.viewpager2.isUserInputEnabled=false

    }
    private inner class ViewpagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when(position)
            {
                0-> FirstTestFragment()
                1-> SecondTestFragment()
                else-> ThirdTestFragment()
            }
        }


    }


}