package com.pdb.weather.data.model

data class WeatherResponse(
    val weather: List<WeatherData>,
    val id: Long,
    val name: String?,
    val cod: Int
)