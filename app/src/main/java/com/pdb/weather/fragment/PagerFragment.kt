package com.pdb.weather.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pdb.weather.data.remote.RetrofitInstance
//import com.pdb.weather.recycler.DailyAdapter
import com.pdb.weather.recycler.HourlyAdapter
import com.pdb.weather.R
import com.pdb.weather.data.model.OneCallWeatherModel
import com.pdb.weather.databinding.FragmentViewPagerBinding
import com.pdb.weather.recycler.DailyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

class PagerFragment : Fragment(R.layout.fragment_view_pager) {

    private val dailyAdapter = DailyAdapter()
    private val hourlyAdapter = HourlyAdapter()
    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
//        binding.btnDetail.setOnClickListener {
//            findNavController().navigate(R.id.action_mainFragment2_to_detailFragment)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            rvHourly.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvHourly.adapter = hourlyAdapter

            rvDaily.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            rvDaily.adapter = dailyAdapter
        }
        val lat = arguments?.getString("lat")
        val lon = arguments?.getString("lon")
        setWeather(lat!!, lon!!)
    }

    private fun setWeather(lat: String, lon: String) {
        RetrofitInstance.api.getForecast(lat = lat, lon = lon)
            .enqueue(object : Callback<OneCallWeatherModel> {
                override fun onResponse(
                    call: Call<OneCallWeatherModel>,
                    response: Response<OneCallWeatherModel>
                ) = if (response.isSuccessful) {
                    binding.tvHumidity.text = "${response.body()?.current?.humidity.toString()}%"
                    binding.tvWindSpeed.text = response.body()?.current?.wind_speed.toString()


                    binding.tvFeels.text = String.format(
                        getString(R.string.feels_like),
                        response.body()?.current?.feels_like?.roundToInt()
                    )
                    binding.tvTemp.text =
                        response.body()?.current?.temp?.roundToInt().toString()
                    binding.tvUvi.text = "${response.body()?.current?.uvi?.roundToInt()}"


                    binding.tvCardMmMin.text = "${response.body()?.daily?.get(0)?.temp?.min?.toInt()}°"
                    binding.tvCardMmMax.text = "${response.body()?.daily?.get(0)?.temp?.max?.toInt()}°"
                    val icon = when (response.body()?.daily?.get(0)?.weather?.get(0)?.main) {
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

                    binding.cardInfoIcon.setImageResource(icon)
                    binding.tvCardState.text = "${response.body()?.daily?.get(0)?.weather?.get(0)?.main}"
                    binding.tvPressure.text = "${response.body()?.current?.pressure}"
                    binding.tvClouds.text = "${response.body()?.current?.clouds}%"
                    binding.tvVisibility.text = "${response.body()?.current?.visibility}"



                    hourlyAdapter.submitList(response.body()?.hourly)
                    dailyAdapter.submitList(response.body()?.daily)
                } else {
                    //TODO: SHOW ERROR
                }

                override fun onFailure(call: Call<OneCallWeatherModel>, t: Throwable) {
                    Log.e("LOGGER", "$t")
                }
            })
    }

}



