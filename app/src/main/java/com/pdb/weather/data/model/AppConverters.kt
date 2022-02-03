package com.pdb.weather.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson

object AppConverters {
    @TypeConverter
    @JvmStatic
    fun fromCurrentData(currentData: CurrentData): String {
        return currentData.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toCurrentData(data: String): CurrentData {
        return Gson().fromJson(data, CurrentData::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun fromMinutelyData(minutelyData: List<MinutelyData>): String {
        return minutelyData.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toMinutelyData(data: String): List<MinutelyData> {
        val dataSet = data.split(",")
        val dataList = mutableListOf<MinutelyData>()
        dataSet.forEach { set ->
            val fromSet = Gson().fromJson(set, MinutelyData::class.java)
            dataList.add(fromSet)
        }
        return dataList
    }

    @TypeConverter
    @JvmStatic
    fun fromHourlyData(hourlyData: List<HourlyData>): String {
        return hourlyData.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toHourlyData(data: String): List<HourlyData> {
        val dataSet = data.split(",")
        val dataList = mutableListOf<HourlyData>()
        dataSet.forEach { set ->
            val fromSet = Gson().fromJson(set, HourlyData::class.java)
            dataList.add(fromSet)
        }
        return dataList
    }

    @TypeConverter
    @JvmStatic
    fun fromDailyData(dailyData: List<DailyData>): String {
        return dailyData.toString()
    }

    @TypeConverter
    @JvmStatic
    fun toDailyData(data: String): List<DailyData> {
        val dataSet = data.split(",")
        val dataList = mutableListOf<DailyData>()
        dataSet.forEach { set ->
            val fromSet = Gson().fromJson(set, DailyData::class.java)
            dataList.add(fromSet)
        }
        return dataList
    }
}