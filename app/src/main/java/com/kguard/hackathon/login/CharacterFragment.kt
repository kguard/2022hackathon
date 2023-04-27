package com.kguard.hackathon.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.kguard.hackathon.MainActivity
import com.kguard.hackathon.R
import com.kguard.hackathon.databinding.FragmentCharacterBinding
import com.kguard.hackathon.databinding.FragmentFirstTestBinding


class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_character,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var color:String ="blue"
        super.onViewCreated(view, savedInstanceState)
        binding.ivBlue.setOnClickListener{
            binding.imageButton.setImageResource(R.drawable.charic_blue)
            color="blue"
        }
        binding.ivPink.setOnClickListener{
            binding.imageButton.setImageResource(R.drawable.charic_pink)
            color="pink"
        }
        binding.btCharacter.setOnClickListener {
            val intent= Intent(activity, MainActivity::class.java)
            intent.putExtra("color",color)
            startActivity(intent)
        }

    }


}