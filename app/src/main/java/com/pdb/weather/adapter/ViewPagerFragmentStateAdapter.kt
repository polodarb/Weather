package com.pdb.weather.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pdb.weather.fragment.PagerFragment

class ViewPagerFragmentStateAdapter(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    private var list = mutableListOf<Pair<String, String>>()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return PagerFragment().apply {
            arguments = Bundle().apply {
                putString("lat", list[position].first)
                putString("lon", list[position].second)
            }
        }
    }

    fun setData(list: MutableList<Pair<String, String>>) {
        this.list = list
    }
}