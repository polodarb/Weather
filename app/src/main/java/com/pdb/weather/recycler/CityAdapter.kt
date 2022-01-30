package com.pdb.weather.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pdb.weather.R

//class CityAdapter(
//    private val context: Context
//) : RecyclerView.Adapter<CityViewHolder>() {
//
//    private var list = mutableListOf<UserModel>() //сюда нужен распарченый список жсона
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false)
//        return CityViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
//        holder.bindData(list[position])
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//}