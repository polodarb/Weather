package com.pdb.weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "onecall_weather")
data class OneCallWeatherModel(
    val lat: Float,
    val lon: Float,
    val timezone: String,
    val timezone_offset: Int,
    val current: CurrentData,
    val minutely: List<MinutelyData>,
    val hourly: List<HourlyData>,
    val daily: List<DailyData>,
    val cityid: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Long
)