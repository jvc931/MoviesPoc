package com.teamb.moviespoc.domain.usecase
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.MovieDetail
import javax.inject.Inject

class GetMovieDetailUseCase@Inject constructor(
    private val repository: MoviesRepository
) {
    suspend operator fun invoke(movie_id:Int): MovieDetail {
        return repository.getMovieDetail(movie_id)
    }
}