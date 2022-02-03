package com.pdb.weather.data.model

data class DailyData(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonset: Long,
    val moon_phase: Float,
    val temp: TempData,
    val feels_like: FeelsLikeData,
    val pressure: Int,
    val humidity: Int,
    val dew_point: Float,
    val wind_speed: Float,
    val wind_deg: Int,
    val wind_gust: Float,
    val weather: List<WeatherData>,
    val clouds: Int,
    val pop: Float,
    val uvi: Float
)
