package com.teamb.moviespoc.data.network
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.model.MovieCreditsDto
import com.teamb.moviespoc.data.model.MovieDetailDto
import com.teamb.moviespoc.data.model.PopularResponseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ResultsApiClient {

    @GET("/3/movie/popular")
    suspend fun getPopularMoviesResult(@Query("api_key") apiKey:String):Response<PopularResponseDto>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") id:Int, @Query("api_key") apiKey:String): Response<MovieDetailDto>

    @GET("/3/movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path("movie_id") id:Int, @Query("api_key") apiKey:String):Response<MovieCreditsDto>

    @GET("/3/movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path("movie_id") id:Int, @Query("api_key") apiKey:String):Response<MovieCreditsDto>


}