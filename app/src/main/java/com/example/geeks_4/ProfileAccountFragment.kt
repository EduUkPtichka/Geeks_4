package com.example.geeks_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeks_4.databinding.FragmentProfileAccountBinding
import com.example.geeks_4.databinding.FragmentTaskBinding

class ProfileAccountFragment : Fragment() {

    private lateinit var binding: FragmentProfileAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileAccountBinding.inflate(inflater, container, false)
        return binding.root
    }



}