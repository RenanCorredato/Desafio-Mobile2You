package com.desafiomobile2you.api



import com.desafiomobile2you.model.Movies
import com.desafiomobile2you.model.Result
import retrofit2.Response
import retrofit2.http.GET


interface TMDBApi {

    @GET("movie/157336/similar?api_key=f59bcbd736acb989e0f913d6c5fcffe7")
    suspend fun getSimilarById():Response<Movies>

}