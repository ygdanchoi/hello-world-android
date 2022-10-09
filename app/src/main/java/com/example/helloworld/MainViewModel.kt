package com.example.helloworld

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel(val repository: MainRepository) : ViewModel() {
    private val _people = MutableStateFlow(listOf<Person>())

    val people: StateFlow<List<Person>>
        get() = _people
}