package com.example.geeks_4.ui.task

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.geeks_4.App
import com.example.geeks_4.R
import com.example.geeks_4.databinding.ActivityMainBinding
import com.example.geeks_4.databinding.FragmentTaskBinding
import com.example.geeks_4.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btmSave.setOnClickListener {
            if (binding.etTitle.text.isEmpty()) {
                binding.etTitle.error = "Введите название"
            } else {
                val data = Task(
                    title = binding.etTitle.text.toString(),
                    desc = binding.etDesc.text.toString()
                )

                App.db.taskDao().insert(data)

                //setFragmentResult(RESULT_KEY, bundleOf(TASK_KEY to data))
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        const val RESULT_KEY = "result.key"
        const val TASK_KEY = "task.key"
    }
}