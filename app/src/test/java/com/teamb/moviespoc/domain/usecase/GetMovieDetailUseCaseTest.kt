package com.teamb.moviespoc.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.domain.model.MovieDetail
import com.teamb.moviespoc.ui.utils.Mocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetMovieDetailUseCaseTest{

    private var moviesRepository: MoviesRepository = mockk()
    lateinit var getMovieDetailUseCase: GetMovieDetailUseCase

    @Before
    fun setUp(){
        //Given
        getMovieDetailUseCase = GetMovieDetailUseCase(moviesRepository)
        coEvery { moviesRepository.getMovieDetail(Mocks.mock_movie_id) } returns Mocks.movieDetail1
        coEvery { moviesRepository.getMovieDetail(Mocks.mock_movie_wrong_id) } returns MovieDetail()
    }
    @Test
    fun `GetMovieDetailUseCase return movie detail for a given id`() = runBlocking{
        // When
        val data = getMovieDetailUseCase(Mocks.mock_movie_id)
        //Then
        coVerify(exactly = 1) { moviesRepository.getMovieDetail(Mocks.mock_movie_id) }
        assertThat(data).isEqualTo(Mocks.movieDetail1)
    }
    @Test
    fun `GetMovieDetailUseCase return empty movie detail for a given wrong id`() = runBlocking{
        // When
        val data = getMovieDetailUseCase(Mocks.mock_movie_wrong_id)
        //Then
        assertThat(data).isEqualTo(MovieDetail())
    }
}