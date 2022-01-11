package uz.shokirov.reyrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.shokirov.entity.Valyuta

interface ApiService {
    @GET("json")
    fun getUsers(): Call<List<Valyuta>>
}