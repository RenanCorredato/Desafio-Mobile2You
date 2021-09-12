package com.desafiomobile2you.features.home.repository

import com.desafiomobile2you.api.ApiService
import com.desafiomobile2you.base.BaseRepository
import com.desafiomobile2you.utils.ResponseApi

class HomeRepository: BaseRepository() {



   suspend fun getSimilarMovies(): ResponseApi {
       return safeApiCall {
            ApiService.tmdbApi.getSimilarById()
        }

    }
}