package com.example.geeks_4.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeks_4.App
import com.example.geeks_4.R
import com.example.geeks_4.databinding.FragmentHomeBinding
import com.example.geeks_4.model.Task
import com.example.geeks_4.ui.home.adapter.TaskAdapter


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val adapter = TaskAdapter(this::onClickOne)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvView.adapter = adapter // может быть ошибка
        val data = App.db.taskDao().getAll()
        adapter.addData(data)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickOne(task: Task) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setMessage("Удалить элемент?")
            .setTitle("Вы уверены, что хотите удалить выбранный элемент?").setNegativeButton(
                "Нет"
            ) { dialog, which -> dialog?.cancel() }.setPositiveButton("Да") { dialog, which ->
                App.db.taskDao().delete(task)
                val tasks = App.db.taskDao().getAll()
                adapter.addData(tasks)
            }.show()

    }

}