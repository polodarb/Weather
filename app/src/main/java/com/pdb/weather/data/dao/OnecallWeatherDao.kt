package com.pdb.weather.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete
import com.pdb.weather.data.model.OneCallWeatherModel
import kotlinx.coroutines.flow.Flow

@Dao
interface OneCallWeatherDao {

    @Insert
    fun insert(oneCallWeatherModel: OneCallWeatherModel)

    @Delete
    fun delete(oneCallWeatherModel: OneCallWeatherModel)

    @Query("SELECT * FROM onecall_weather WHERE cityid = :cityid")
    fun showAll(cityid: Long): List<OneCallWeatherModel>
}