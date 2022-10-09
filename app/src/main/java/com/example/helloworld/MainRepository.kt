package com.example.helloworld

class MainRepository(private val apiService: MainService) {
    suspend fun getPeople(): List<Person> {
        val response = apiService.getPeople()
        return if (response.isSuccessful) {
            response.body() ?: ERROR
        } else {
            ERROR
        }
    }

    companion object {
        val ERROR = listOf(Person(name = "Error fetching people."))
    }
}