package com.teamb.moviespoc.data.network

import com.teamb.moviespoc.data.model.MovieDetailDto
import com.teamb.moviespoc.data.model.PopularMovieDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesService @Inject constructor(private val apiClient: ResultsApiClient) {

    suspend fun getPopularMovies(): List<PopularMovieDto>{
        return withContext(Dispatchers.IO){
            val response = apiClient.getPopularMoviesResult("2c6ad4a84f72acef01de56e51a16573e")
            response.body()?.results ?: emptyList()
        }
    }

    suspend fun getMovieDetail(movie_id: Int): MovieDetailDto{
        return withContext(Dispatchers.IO){
            val response = apiClient.getMovieDetail(movie_id,"2c6ad4a84f72acef01de56e51a16573e")
            response.body() ?: MovieDetailDto()
        }
    }
}