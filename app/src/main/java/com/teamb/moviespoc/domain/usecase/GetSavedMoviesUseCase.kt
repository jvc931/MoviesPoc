package com.teamb.moviespoc.domain.usecase
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.PopularMovie
import javax.inject.Inject

class GetSavedMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(): List<PopularMovie> {
        return repository.getSavedMovies()
    }
}