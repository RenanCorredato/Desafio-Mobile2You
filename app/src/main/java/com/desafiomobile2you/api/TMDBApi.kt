package com.desafiomobile2you.api



import com.desafiomobile2you.model.MovieDetails
import com.desafiomobile2you.model.Movies
import com.desafiomobile2you.model.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface TMDBApi {

    @GET("movie/157336/similar")
    suspend fun getSimilarById():Response<Movies>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailsById(
        @Path("movie_id") moviesId: Int
    ):Response<MovieDetails>

}