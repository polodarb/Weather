package com.pdb.test_weather.data.remote

import com.pdb.test_weather.data.model.OnecallWeatherResponse
import com.pdb.test_weather.data.model.WeatherResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.openweathermap.org"
private const val API_KEY = "994307b8e3f08471292c33d26a1f5ecf"


interface ApiCall {
    @GET("data/2.5/onecall")
    fun getForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String = "metric",
        @Query("exclude") exclude: String = "alerts",
        @Query("appid") appid: String = API_KEY,
        @Query("lang") lang: String = "ru"
    ): Call<OnecallWeatherResponse>

    @GET("data/2.5/weather")
    fun getCity(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = API_KEY,
        @Query("lang") lang: String = "ru"
    ): Call<WeatherResponse>
}

object RetrofitInstance {

    private val client = OkHttpClient.Builder().build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiCall by lazy {
        retrofit.create(ApiCall::class.java)
    }
}
