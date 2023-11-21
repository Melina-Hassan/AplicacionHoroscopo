package com.melhass.horoscapp.ui.horoscope.adapter

import android.content.Context
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.melhass.horoscapp.databinding.ItemHoroscopeBinding
import com.melhass.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val contexto: Context = binding.tvTitleHoroscope.context

        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitleHoroscope.text = contexto.getString(horoscopeInfo.name)

        binding.clHoroscope.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, func = { onItemSelected(horoscopeInfo) })
            //onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnimation(view: View, func: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { func() }
            start()
        }
    }
}