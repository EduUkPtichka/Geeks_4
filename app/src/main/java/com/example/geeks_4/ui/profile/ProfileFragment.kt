package com.example.geeks_4.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.example.geeks_4.R
import com.example.geeks_4.data.Pref
import com.example.geeks_4.databinding.FragmentProfileBinding
import com.example.geeks_4.utils.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val pref by lazy {
        Pref(requireContext())
    }

    private val galleryLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val photoUri = result.data?.data
                pref.saveImage(photoUri.toString())
                binding.profileImage.loadImage(photoUri.toString())
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileImage.loadImage(pref.getImage().toString())
        binding.etName.setText(pref.getText())

        binding.profileImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            galleryLauncher.launch(intent)
        }

        binding.etName.addTextChangedListener {
            pref.saveText(it.toString())
        }
    }

}