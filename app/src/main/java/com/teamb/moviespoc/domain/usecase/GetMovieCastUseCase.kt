package com.teamb.moviespoc.domain.usecase

import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.Cast
import com.teamb.moviespoc.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieCastUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    //GetMovieCastUseCase for Flow
    suspend operator fun invoke(movie_id:Int): List<Cast> {
        return repository.getMovieCredits(movie_id)
    }
}