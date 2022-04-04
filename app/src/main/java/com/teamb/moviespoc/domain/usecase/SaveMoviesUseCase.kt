package com.teamb.moviespoc.domain.usecase

import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(movie: PopularMovie) {
        return repository.saveMovie(movie)
    }
}