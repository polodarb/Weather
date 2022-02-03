package com.pdb.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pdb.weather.databinding.FragmentCityBinding

class CityFragment : Fragment() {
    lateinit var fragmentCityBinding: FragmentCityBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentCityBinding = FragmentCityBinding.inflate(inflater, container, false)
        return fragmentCityBinding.root
    }
}