package com.example.geeks_4.ui.onboarding.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_4.databinding.ItemOnboardingBinding
import com.example.geeks_4.model.OnBoarding
import com.example.geeks_4.utils.loadImage
import com.bumptech.glide.Glide as Glide

class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding(
            "https://cdn-icons-png.flaticon.com/512/4345/4345573.png",
            "Смори",
            "Отмечай, понял!",
        ),
        OnBoarding(
            "https://telegra.ph/file/6c366ae47e238a3366ee9.jpg",
            "7 000р.",
            "Кролик Ушастый"

        ),
        OnBoarding(
            "https://lamcdn.net/wonderzine.com/community-topic_image-image/idzYpjfTcIYTI-cEUlUrFQ.jpg",
            "9 000р.",
            "Платье МЯСНИКА",
        ),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {

        return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private var binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(onBoarding: OnBoarding) {

            binding.ivBoardItem.loadImage(onBoarding.image)

            binding.btmStart.setOnClickListener {
                onClick()
            }
            binding.btnSkip.setOnClickListener {
                onClick()
            }
            binding.btnSkip.isVisible = adapterPosition == data.lastIndex
            binding.btnSkip.isVisible = adapterPosition != data.lastIndex

            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            Glide.with(binding.ivBoardItem).load(onBoarding.image).into(binding.ivBoardItem)

        }
    }
}
