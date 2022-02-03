package com.pdb.weather.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.pdb.weather.data.model.HourlyData
import com.pdb.weather.databinding.ItemHourlyBinding

class HourlyAdapter : ListAdapter<HourlyData, HourlyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HourlyViewHolder(
        ItemHourlyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HourlyData>() {
            override fun areItemsTheSame(oldItem: HourlyData, newItem: HourlyData): Boolean =
                oldItem.dt == newItem.dt

            override fun areContentsTheSame(oldItem: HourlyData, newItem: HourlyData): Boolean =
                oldItem == newItem
        }
    }
}