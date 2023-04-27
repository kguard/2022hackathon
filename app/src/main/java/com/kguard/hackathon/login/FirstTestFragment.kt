package com.kguard.hackathon.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentFirstTestBinding

class FirstTestFragment : Fragment() {
    private lateinit var binding: FragmentFirstTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_first_test,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btNexttext1.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=1
        }
        binding.tvFirstTest1.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=1
        }
        binding.tvFirstTest2.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=1
        }
        binding.tvFirstTest3.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=1
        }
    }


}