package com.example.helloworld

import retrofit2.Response
import retrofit2.http.GET

interface MainService {
    @GET("people")
    suspend fun getPeople(): Response<List<Person>>
}