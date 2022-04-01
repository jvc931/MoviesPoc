package com.teamb.moviespoc.ui.utils

import com.teamb.moviespoc.domain.model.Cast
import com.teamb.moviespoc.domain.model.MovieDetail
import com.teamb.moviespoc.domain.model.PopularMovie

object Mocks {
    val movie1 = PopularMovie(
        originalTitle = "Movie1",
        title = "Original movie1",
        voteCount = 100
    )
    val movie2 = PopularMovie(
        originalTitle = "Movie2",
        title = "Original movie2",
        voteCount = 50
    )
    val fakeListPopularMovies = listOf(movie1, movie2)
    val movieDetail1 = MovieDetail(
        title = "original movie1",
        overview = "movie description",
        video = true
    )
    val castList = listOf(
        Cast(
            name = "Pepito perez"
        ),
        Cast(
            name = "Armando casas"
        )
    )
}