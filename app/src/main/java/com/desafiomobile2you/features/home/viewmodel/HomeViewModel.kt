package com.desafiomobile2you.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.desafiomobile2you.base.BaseViewModel
import com.desafiomobile2you.features.usecase.HomeUseCase
import com.desafiomobile2you.model.Result
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    private val homeUseCase = HomeUseCase()

    private val _onSuccessSimilar: MutableLiveData<List<Result>> =
        MutableLiveData()

    val onSuccessSimilar: LiveData<List<Result>>
        get() = _onSuccessSimilar

    private val _onErrorSimilar: MutableLiveData<Int> =
        MutableLiveData()

    val onErrorSimilar: LiveData<Int>
        get() = _onErrorSimilar

    fun getSimilarMovies() {
        viewModelScope.launch {
            callApi(
                suspend {homeUseCase.getSimilarMovies()},
                onSuccess = {
                    val result = it as? List<*>
                    _onSuccessSimilar.postValue(
                        result?.filterIsInstance<Result>()
                    )

                },
            )
        }
    }

    fun getMovieDetailsById(id: Int) {
        viewModelScope.launch {
            callApi(
                suspend { homeUseCase.getMovieDetailsById(id) },
                onSuccess = {
                    it
                }
            )
        }
    }
}