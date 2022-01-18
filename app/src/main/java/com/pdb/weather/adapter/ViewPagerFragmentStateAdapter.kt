package com.pdb.weather.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pdb.weather.fragment.PagerFragment

class ViewPagerFragmentStateAdapter(
    activity: FragmentActivity
) : FragmentStateAdapter(activity) {

    private var list = mutableListOf<String>()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return PagerFragment().apply {
            arguments = Bundle().apply {
                putString("title", list[position])
            }
        }
    }

    fun setData(list: MutableList<String>) {
        this.list = list
    }
}