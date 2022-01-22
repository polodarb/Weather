//package com.pdb.test_weather.ui.recycler
//
//import androidx.recyclerview.widget.RecyclerView
//import com.pdb.test_weather.data.model.DailyData
//import com.pdb.weather.R
//import com.pdb.weather.databinding.ItemDailyBinding
//import java.text.SimpleDateFormat
//import java.util.*
//import kotlin.math.roundToInt
//
//class DailyViewHolder(private val binding: ItemDailyBinding) :
//    RecyclerView.ViewHolder(binding.root) {
//    private val simpleDOWFormat = SimpleDateFormat("EEE", Locale.ENGLISH)
//    private val simpleDateFormat = SimpleDateFormat("dd/MM", Locale.ENGLISH)
//
//    fun bind(data: DailyData) {
//
////        binding.hourlyMain.text = data.weather[0].description
////        binding.hourlyTemp.text = "${data.temp.day.roundToInt()}°C"
//
//        val dow = simpleDOWFormat.format(data.dt * 1000L)
//        val dt = simpleDateFormat.format(data.dt * 1000L)
//
//        binding.dailyDayOfWeek.text = dow
//        binding.dailyDay.text = dt
//
//        val icon = when (data.weather[0].main) {
//            "Rain" -> {
//                R.drawable.ic_light_rain
//            }
//            "Snow" -> {
//                R.drawable.ic_light_snow}
//            "Clouds" -> {
//                R.drawable.ic_cloudy}
//            "Clear" -> {
//                R.drawable.ic_sun}
//            else -> {
//                R.drawable.ic_na}
//        }
//
//        binding.dailyIcon.setImageResource(icon)
//    }
//}