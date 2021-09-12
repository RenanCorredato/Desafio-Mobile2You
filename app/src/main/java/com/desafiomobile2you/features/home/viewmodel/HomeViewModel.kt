package com.desafiomobile2you.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiomobile2you.features.usecase.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeUseCase = HomeUseCase()

    fun getSimilarMovies() {
        viewModelScope.launch {
            homeUseCase.getSimilarMovies()
        }
    }
}