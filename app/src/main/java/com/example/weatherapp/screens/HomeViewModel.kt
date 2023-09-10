package com.example.weatherapp.screens

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.BaseModel
import com.example.weatherapp.repositories.WeatherRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    val repo: WeatherRepo by inject()

    private val _locations: MutableStateFlow<BaseModel<List<Location>>?> = MutableStateFlow(null)
    val locations = _locations.asStateFlow()

    fun searchLocation(query: String) {
        viewModelScope.launch {
            _locations.update { BaseModel.Loading }
            repo.searchLocation(query).also {
                _locations.update { it }
            }
        }
    }
}
