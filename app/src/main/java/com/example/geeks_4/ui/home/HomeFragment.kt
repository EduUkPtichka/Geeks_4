package com.example.geeks_4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.geeks_4.R
import com.example.geeks_4.databinding.FragmentHomeBinding
import com.example.geeks_4.model.Task
import com.example.geeks_4.ui.home.adapter.TaskAdapter
import com.example.geeks_4.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.geeks_4.ui.task.TaskFragment.Companion.TASK_KEY

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter()

    private val binding get () = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvView.adapter = adapter

        setFragmentResultListener(RESULT_KEY){ requestKey, bundle ->
            val data = bundle.getSerializable(TASK_KEY) as Task
            adapter.setData(data)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}