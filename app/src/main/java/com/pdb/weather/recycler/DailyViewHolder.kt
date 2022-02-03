package com.pdb.weather.recycler

import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.pdb.weather.data.model.DailyData
import com.pdb.weather.R
import com.pdb.weather.databinding.ItemDailyBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

class DailyViewHolder(private val binding: ItemDailyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val simpleDOWFormat = SimpleDateFormat("EEE", Locale.ENGLISH)

    fun bind(data: DailyData) {

        val dow = simpleDOWFormat.format(data.dt * 1000L)

        binding.dailyWeekTv.text = dow

        val icon = when (data.weather[0].main) {
            "Rain" -> {
                R.drawable.ic_light_rain
            }
            "Snow" -> {
                R.drawable.ic_light_snow
            }
            "Clouds" -> {
                R.drawable.ic_cloud
            }
            "Clear" -> {
                R.drawable.ic_sun
            }
            else -> {
                R.drawable.ic_na
            }
        }

        val context = binding.root.context
        val drawable = AppCompatResources.getDrawable(context, icon)
        binding.dailyWeatherState.text = data.weather[0].main
        binding.dailyWeatherState.setCompoundDrawablesRelative(drawable, null, null, null)
        binding.tvCardDailyMmMax.text = "${data.temp.max.roundToInt()}°"
        binding.tvCardDailyMmMin.text = "${data.temp.min.roundToInt()}°"
    }
}