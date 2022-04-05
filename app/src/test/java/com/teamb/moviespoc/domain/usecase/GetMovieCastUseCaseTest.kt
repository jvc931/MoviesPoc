package com.teamb.moviespoc.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.ui.utils.Mocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieCastUseCaseTest{

    private var moviesRepository: MoviesRepository = mockk()
    lateinit var getMovieCastUseCase: GetMovieCastUseCase

    @Before
    fun setUp(){
        //Given
        getMovieCastUseCase = GetMovieCastUseCase(moviesRepository)
        coEvery { moviesRepository.getMovieCredits(Mocks.mock_movie_id) } returns Mocks.castList
        coEvery { moviesRepository.getMovieCredits(Mocks.mock_movie_wrong_id) } returns emptyList()
    }

    @Test
    fun `GetMovieCastUseCase return the cast list for a given movie id`() = runBlocking{
        //When
        val result = getMovieCastUseCase(Mocks.mock_movie_id)
        //Then
        coVerify(exactly = 1) { moviesRepository.getMovieCredits(Mocks.mock_movie_id) }
        assertThat(result).isEqualTo(Mocks.castList)
    }

    @Test
    fun `GetMovieCastUseCase return an empty list for a given wring movie id`() = runBlocking{
        //When
        val result = getMovieCastUseCase(Mocks.mock_movie_wrong_id)
        //Then
        assertThat(result).isEmpty()
    }

}