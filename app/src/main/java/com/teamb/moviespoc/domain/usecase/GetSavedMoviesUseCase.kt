package com.teamb.moviespoc.domain.usecase

import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.PopularMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(): Flow<List<PopularMovie>> {
        return repository.getSavedMovies()
    }
}