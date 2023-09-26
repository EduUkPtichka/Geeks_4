package com.example.geeks_4.ui.onboarding


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.geeks_4.databinding.ItemOnboardingBinding
import com.example.geeks_4.model.OnBoarding
import com.bumptech.glide.Glide as Glide

class Adapter(private val onClick: () -> Unit) : RecyclerView.Adapter<Adapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding(
            "https://static.batnorton.com/image/39339-617fc77652c220.66661445/700x980-1_1765567485.jpg",
            "30 000р",
            "Зимняя куртка КИМОНО",
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
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class OnBoardingViewHolder(private var binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
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
