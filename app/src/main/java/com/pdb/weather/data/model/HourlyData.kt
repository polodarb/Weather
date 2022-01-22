package com.pdb.test_weather.data.model

data class HourlyData(
    val dt: Long,
    val temp: Float,
    val feels_like: Float,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Float,
    val uvi: Float,
    val clouds: Int,
    val visibility: Int,
    val wind_speed: Float,
    val wind_deg: Int,
    val wind_gust: Float,
    val weather: List<WeatherData>,
    val pop: Float
)