package com.example.helloworld

import retrofit2.Call
import retrofit2.http.GET

interface MainService {
    @GET("people")
    fun getPeople(): Call<List<Person>>
}