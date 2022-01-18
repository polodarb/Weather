package com.pdb.weather.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pdb.weather.R
import com.pdb.weather.databinding.FragmentViewPagerBinding
import com.pdb.weather.databinding.HomeFragmentBinding

const val ARG_OBJECT = "object"

class ViewPager : Fragment() {

    lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }


    }