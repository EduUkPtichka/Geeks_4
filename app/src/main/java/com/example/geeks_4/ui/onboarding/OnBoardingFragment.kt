package com.example.geeks_4.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeks_4.databinding.FragmentOnBoardingBinding
import androidx.navigation.fragment.findNavController
import com.example.geeks_4.data.Pref


class  OnBoardingFragment : Fragment() {

    private val pref by lazy {
        Pref(requireContext())
    }

    private lateinit var binding: FragmentOnBoardingBinding
    private val adapter = Adapter(this::onClick)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding
            .inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.attachTo(binding.viewPager)
    }
    private fun onClick(){
        pref.userShowed()
        findNavController().navigateUp()
    }
}

