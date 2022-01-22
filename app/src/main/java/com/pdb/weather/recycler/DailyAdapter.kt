//package com.pdb.test_weather.ui.recycler
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import com.pdb.test_weather.data.model.DailyData
//import com.pdb.weather.databinding.ItemDailyBinding
//
//class DailyAdapter : ListAdapter<DailyData, DailyViewHolder>(DIFF_CALLBACK) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DailyViewHolder(
//        ItemDailyBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//        )
//    )
//
//    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
//        holder.bind(getItem(position))
//    }
//
//    companion object {
//        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DailyData>() {
//            override fun areItemsTheSame(oldItem: DailyData, newItem: DailyData): Boolean =
//                oldItem.dt == newItem.dt
//
//            override fun areContentsTheSame(oldItem: DailyData, newItem: DailyData): Boolean =
//                oldItem == newItem
//        }
//    }
//}