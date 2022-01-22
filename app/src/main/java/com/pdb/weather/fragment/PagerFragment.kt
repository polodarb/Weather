package com.pdb.weather.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
//import com.pdb.test_weather.ui.recycler.DailyAdapter
import com.pdb.test_weather.ui.recycler.HourlyAdapter
import com.pdb.weather.R
import com.pdb.weather.databinding.FragmentViewPagerBinding

class PagerFragment : Fragment(R.layout.fragment_view_pager) {

//    private val daily_adapter = DailyAdapter()
    private val hourly_adapter = HourlyAdapter()
    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        binding.apply {
            rvHourly.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvHourly.adapter = hourly_adapter}

//            rvDaily.layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            rvDaily.adapter = daily_adapter}
//        setWeather()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            val titlePage = it.getString("title")
        }
    }
}



//hourly_adapter.submitList(response.body()?.hourly)
//daily_adapter.submitList(response.body()?.daily)