package com.desafiomobile2you.api



import com.desafiomobile2you.model.Result
import retrofit2.Response
import retrofit2.http.GET


interface TMDBApi {



    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarById():Response<Result>

}