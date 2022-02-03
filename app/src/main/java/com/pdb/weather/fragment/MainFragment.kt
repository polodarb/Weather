package com.pdb.weather.fragment

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.pdb.weather.CityFragment
import com.pdb.weather.data.model.WeatherResponse
import com.pdb.weather.data.remote.RetrofitInstance
import com.pdb.weather.R
import com.pdb.weather.adapter.ViewPagerFragmentStateAdapter
import com.pdb.weather.databinding.HomeFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    lateinit var locationManager: LocationManager
    lateinit var binding: HomeFragmentBinding
    val cityList: MutableList<Pair<String, String>> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerFragmentStateAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        val lat = getLocation()?.first
        val lon = getLocation()?.second

        getCity(lat!!, lon!!)
        cityList.add(Pair(lat, lon))
        cityList.add(Pair("34.0522", "-118.244"))
        adapter.setData(cityList)
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                getCity(cityList[position].first, cityList[position].second)
            }
        })

        binding.toolbarHome.inflateMenu(R.menu.home_menu)
        binding.toolbarHome.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_city -> {
                    findNavController().navigate(R.id.cityFragment)
                    true
                }
                else -> {
                    super.onOptionsItemSelected(it)
                }
            }
        }
    }

    fun getCity(lat: String, lon: String) {
        RetrofitInstance.api.getCity(lat = lat, lon = lon)
            .enqueue(object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if (response.isSuccessful) {
                        binding.toolbarHome.title = response.body()?.name!!
                    } else {
                        //
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    Log.e("LOGGER", "$t")
                }
            })
    }

    fun getLocation(): Pair<String, String>? {
        if (ActivityCompat.checkSelfPermission(
                requireActivity(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireActivity(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                0
            )
        }

        locationManager =
            requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val hasGps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val hasNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        var locationGps = Location(LocationManager.GPS_PROVIDER)
        var locationNetwork = Location(LocationManager.NETWORK_PROVIDER)

        if (hasGps || hasNetwork) {
            if (hasGps) {
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER, 5000, 0F
                ) { p0 ->
                    locationGps = p0
                }

                val localGpsLocation =
                    locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (localGpsLocation != null)
                    locationGps = localGpsLocation
            }
            if (hasNetwork) {
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER, 5000, 0F
                ) { p0 -> locationNetwork = p0 }

                val localNetworkLocation =
                    locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                if (localNetworkLocation != null)
                    locationNetwork = localNetworkLocation
            }
            if (locationGps != null && locationNetwork != null) {
                return if (locationGps.accuracy > locationNetwork.accuracy) {
                    Pair(locationGps.latitude.toString(), locationGps.longitude.toString())
                } else {
                    Pair(
                        locationNetwork.latitude.toString(),
                        locationNetwork.longitude.toString()
                    )
                }
            }

        } else {
            startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
        }
        return null
    }
}