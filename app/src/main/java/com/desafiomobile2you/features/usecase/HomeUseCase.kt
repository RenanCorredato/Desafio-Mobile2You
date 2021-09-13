package com.desafiomobile2you.features.usecase

import com.desafiomobile2you.api.ApiService
import com.desafiomobile2you.extensions.getFullImageUrl
import com.desafiomobile2you.features.home.repository.HomeRepository
import com.desafiomobile2you.model.Movies
import com.desafiomobile2you.utils.ResponseApi

class HomeUseCase {

    private val homeRepository = HomeRepository()

    suspend fun getSimilarMovies():ResponseApi {
       return when (val responseApi = homeRepository.getSimilarMovies()) {
            is ResponseApi.Success -> {
                val data = responseApi.data as? Movies
                val result = data?.results?.map {
                    it.backdropPath = it.backdropPath.getFullImageUrl()
                    it.posterPath = it.posterPath.getFullImageUrl()
                    it
                }
                ResponseApi.Success(result)
            }

            is ResponseApi.Error -> {
                responseApi
            }
        }
    }
}