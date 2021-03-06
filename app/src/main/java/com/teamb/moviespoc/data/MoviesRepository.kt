package com.teamb.moviespoc.data
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.db.MoviesDao
import com.teamb.moviespoc.data.network.MoviesService
import com.teamb.moviespoc.domain.model.Cast
import com.teamb.moviespoc.domain.model.MovieDetail
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.domain.model.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val api: MoviesService,
    private val dao: MoviesDao
){
    //Function getAllPopularResults() for LiveData
    /*suspend fun getAllPopularResults(): List<PopularMovie>{
        val response = api.getPopularMovies()
        return response.map { it.toDomain() }
    }*/
    suspend fun getMovieDetail(movie_id: Int): MovieDetail{
        val response = api.getMovieDetail(movie_id)
        return response.toDomain()
    }
    //Function getAllPopularResults() for Flow
    fun getAllPopularResults(): Flow<List<PopularMovie>> = flow{
        val response = api.getPopularMovies()
        emit(response.map { it.toDomain()} )
    }
    //Function getAllPopularResults() for Flow
    suspend fun getMovieCredits(movie_id: Int): List<Cast>{
        val response = api.getMovieCredits(movie_id)
        return response.map { it.toDomain()}
    }

    fun getSavedMovies() : Flow<List<PopularMovie>> {
        return dao.getSavedMovies()
    }

    suspend fun saveMovie(movie: PopularMovie) {
        dao.insert(movie)
    }

}