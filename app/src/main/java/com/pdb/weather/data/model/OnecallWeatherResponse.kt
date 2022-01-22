package com.pdb.test_weather.data.model

data class OnecallWeatherResponse(
    val lat: Float,
    val lon: Float,
    val timezone: String,
    val timezone_offset: Int,
    val current: CurrentData,
    val minutely: List<MinutelyData>,
    val hourly: List<HourlyData>,
    val daily: List<DailyData>
)