package com.pdb.weather

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pdb.weather.data.model.OneCallWeatherModel
import com.pdb.weather.data.dao.OneCallWeatherDao
import com.pdb.weather.data.model.AppConverters

@Database(entities = [OneCallWeatherModel::class], version = 1)
@TypeConverters(AppConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val oneCallWeatherDao: OneCallWeatherDao
}