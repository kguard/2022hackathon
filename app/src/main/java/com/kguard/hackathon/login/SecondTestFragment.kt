package com.kguard.hackathon.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentFirstTestBinding
import com.kguard.hackathon.databinding.FragmentSecondTestBinding

class SecondTestFragment : Fragment() {
    private lateinit var binding: FragmentSecondTestBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_second_test,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btNexttext2.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=2
        }
        binding.ivSecondAnswer2.setOnClickListener{
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=2
        }
        binding.ivSecondAnswer3.setOnClickListener{
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=2
        }
        binding.ivSecondAnswer4.setOnClickListener{
            activity?.findViewById<ViewPager2>(R.id.viewpager2)?.currentItem=2
        }
    }


}