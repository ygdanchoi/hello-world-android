package com.example.helloworld

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _people = MutableStateFlow(listOf<Person>())

    val people: StateFlow<List<Person>>
        get() = _people

    init {
        fetchPeople()
    }

    private fun fetchPeople() {
        viewModelScope.launch {
            _people.value = repository.getPeople()
        }
    }
}