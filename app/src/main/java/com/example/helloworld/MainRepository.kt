package com.example.helloworld

class MainRepository(private val apiService: MainService) {
    suspend fun getPeople(): List<Person> =
        apiService.getPeople().body() ?: listOf() // TODO: proper error handling
}