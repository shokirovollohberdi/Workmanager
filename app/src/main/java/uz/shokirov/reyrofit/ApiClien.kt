package uz.shokirov.reyrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClien {
    const val BASE_URL = "http://cbu.uz/uzc/arkhiv-kursov-valyut/"

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}