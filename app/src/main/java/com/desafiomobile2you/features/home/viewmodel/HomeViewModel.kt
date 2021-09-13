package com.desafiomobile2you.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiomobile2you.features.usecase.HomeUseCase
import com.desafiomobile2you.model.Result
import com.desafiomobile2you.utils.ResponseApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

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
           when(val responseApi = homeUseCase.getSimilarMovies()){
               is ResponseApi.Success ->{
                   _onSuccessSimilar.postValue(responseApi.data as? List<Result>)
               }

               is ResponseApi.Error ->{
                    _onErrorSimilar.postValue(responseApi.message)
               }
           }
        }
    }
}