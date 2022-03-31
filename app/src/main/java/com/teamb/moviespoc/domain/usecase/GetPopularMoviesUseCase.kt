package com.teamb.moviespoc.domain.usecase
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
){
    //GetPopularMoviesUseCase for LiveData
    /*suspend operator fun invoke(): List<PopularMovie> {
        return repository.getAllPopularResults()
    }*/

    //GetPopularMoviesUseCase for Flow
    operator fun invoke(): Flow<List<PopularMovie>> {
        return repository.getAllPopularResults()
    }
}