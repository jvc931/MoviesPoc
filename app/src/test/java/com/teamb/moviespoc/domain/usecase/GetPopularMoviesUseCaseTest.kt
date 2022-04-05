package com.teamb.moviespoc.domain.usecase

import com.google.common.truth.Truth.assertThat
import com.teamb.moviespoc.data.MoviesRepository
import com.teamb.moviespoc.ui.extensions.asFlow
import com.teamb.moviespoc.ui.utils.Mocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPopularMoviesUseCaseTest{

    private var moviesRepository: MoviesRepository = mockk()
    lateinit var getPopularMoviesUseCase: GetPopularMoviesUseCase

    @Before
    fun setUp(){
        //Given
        getPopularMoviesUseCase = GetPopularMoviesUseCase(moviesRepository)
    }

    @Test
    fun `GetPopularMoviesUseCase return a flow with a list of popular movies`() = runBlocking{
        //Given
        coEvery { moviesRepository.getAllPopularResults() } returns Mocks.fakeListPopularMovies.asFlow()
        //When
        val movies  = getPopularMoviesUseCase().toList()
        //Then
        assertThat(movies).isNotEmpty()
        assertThat(movies[0]).isEqualTo(Mocks.fakeListPopularMovies)
        assertThat(movies[0][0]).isEqualTo(Mocks.movie1)
        assertThat(movies[0][1]).isEqualTo(Mocks.movie2)
    }
    @Test
    fun `GetPopularMoviesUseCase return a flow with emptyList`() = runBlocking{
        //Given
        coEvery { moviesRepository.getAllPopularResults() } returns emptyFlow()
        //When
        val movies  = getPopularMoviesUseCase().toList()
        //Then
        assertThat(movies).isEmpty()
    }

}