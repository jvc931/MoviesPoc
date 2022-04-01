package com.teamb.moviespoc.ui.viewmodel

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.domain.usecase.GetMovieCastUseCase
import com.teamb.moviespoc.domain.usecase.GetMovieDetailUseCase
import com.teamb.moviespoc.domain.usecase.GetPopularMoviesUseCase
import com.teamb.moviespoc.ui.extensions.asFlow
import com.teamb.moviespoc.ui.utils.Mocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PopularViewModelTest{

    private lateinit var viewModel: PopularViewModel
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase = mockk()
    private val getMovieDetailUseCase : GetMovieDetailUseCase = mockk()
    private val getMovieCastUseCase : GetMovieCastUseCase = mockk()


    @Before
    fun setUp(){
        //Given
        coEvery { getPopularMoviesUseCase.invoke() } returns Mocks.fakeListPopularMovies.asFlow()
        coEvery { getMovieDetailUseCase.invoke(634649) } returns Mocks.movieDetail1
        coEvery { getMovieCastUseCase.invoke(634649)} returns Mocks.castList
        viewModel = PopularViewModel(getPopularMoviesUseCase,getMovieCastUseCase,getMovieDetailUseCase)
    }
    @Test
    fun `popular movies flow is getting the information from the getPopularMoviesUseCase`() = runTest {
        viewModel.popularMovies.test{
            //When
            val emission = awaitItem()
            //Then
            assertThat(emission).isEqualTo(listOf(Mocks.movie1, Mocks.movie2))
            assertThat(emission).isNotEqualTo(listOf(Mocks.movie2, Mocks.movie1))
            assertThat(emission).isNotEqualTo(listOf(PopularMovie()))
            cancelAndConsumeRemainingEvents()
        }
    }
    @Test
    fun `movie details get the information from the GetMovieDetailUseCase`() = runBlocking {
        //When
        viewModel.getMovieDetail(634649)
        delay(100)
        //Then
        assertThat(viewModel.movie.value).isEqualTo((Mocks.movieDetail1))
    }
    @Test
    fun `movie cast get the information from the getMovieDetailUseCase`() = runBlocking {
        //When
        viewModel.getMovieDetail(634649)
        delay(100)
        //Then
        assertThat(viewModel.castList.value).isNotEmpty()
        assertThat(viewModel.castList.value).isEqualTo((Mocks.castList))
    }
}

