package com.pdb.weather.recycler

import androidx.recyclerview.widget.RecyclerView
import com.pdb.weather.data.model.HourlyData
import com.pdb.weather.R
import com.pdb.weather.databinding.ItemHourlyBinding
import java.text.SimpleDateFormat

import java.util.*
import kotlin.math.roundToInt

class HourlyViewHolder(private val binding: ItemHourlyBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val simpleDateFormat = SimpleDateFormat("HH:mm", Locale.ENGLISH)

    fun bind(data: HourlyData) {

//        binding.hourlyMain.text = data.weather[0].description
        binding.hourlyTemp.text = "${data.temp.roundToInt()}°C"

        val dt = simpleDateFormat.format(data.dt * 1000L)

        binding.hourlyTime.text = dt

        val icon = when (data.weather[0].main) {
            "Rain" -> {
                R.drawable.ic_light_rain
            }
            "Snow" -> {
                R.drawable.ic_light_snow}
            "Clouds" -> {
                R.drawable.ic_cloud
            }
            "Clear" -> {
                R.drawable.ic_sun}
            "Fog" -> {
                R.drawable.ic_fog}
            else -> {
                R.drawable.ic_na}
        }

        binding.hourlyIcon.setImageResource(icon)
    }
}