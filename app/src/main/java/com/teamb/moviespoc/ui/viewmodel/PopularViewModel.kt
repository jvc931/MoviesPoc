package com.teamb.moviespoc.ui.viewmodel
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.moviespoc.domain.model.Cast
import com.teamb.moviespoc.domain.model.MovieDetail
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.domain.usecase.GetMovieCastUseCase
import com.teamb.moviespoc.domain.usecase.GetMovieDetailUseCase
import com.teamb.moviespoc.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getMovieCastUseCase: GetMovieCastUseCase,
    private val getMovieDetailUseCase: GetMovieDetailUseCase
): ViewModel(){
     //popularMovies to use livedata
     //val popularMovies : MutableState<List<PopularMovie>> = mutableStateOf(listOf())
     //popularMovies to use Flow
     val popularMovies : Flow<List<PopularMovie>> = getPopularMoviesUseCase()
    val movie : MutableState<MovieDetail> = mutableStateOf(MovieDetail())
    val castList : MutableState<List<Cast>> = mutableStateOf(listOf())

    fun onCreate(){
        //popularMovies to use livedata
       /* viewModelScope.launch(Dispatchers.IO) {
            val result = getPopularMoviesUseCase()
            if(!result.isNullOrEmpty()){
                popularMovies.value = result
            }
            movie.value = getMovieDetailUseCase(634649)
        }*/
        viewModelScope.launch(Dispatchers.IO) {
            movie.value = getMovieDetailUseCase(508947)
            castList.value = getMovieCastUseCase(508947)
        }
    }

    fun getMovieDetail(movieID:Int){
        viewModelScope.launch(Dispatchers.IO) {
            movie.value = getMovieDetailUseCase(movieID)
            castList.value = getMovieCastUseCase(movieID)
        }
    }


}