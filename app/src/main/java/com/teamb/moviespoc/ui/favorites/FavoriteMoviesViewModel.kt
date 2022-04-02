package com.teamb.moviespoc.ui.favorites

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.domain.usecase.GetSavedMoviesUseCase
import com.teamb.moviespoc.domain.usecase.SaveMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
    getSavedMoviesUseCase: GetSavedMoviesUseCase,
    private val saveMoviesUseCase: SaveMoviesUseCase
): ViewModel(){
     // saved movies to use Flow
     var savedMovies : Flow<List<PopularMovie>> = getSavedMoviesUseCase()


    fun insert(movie: PopularMovie) {
        viewModelScope.launch(Dispatchers.IO) {
            saveMoviesUseCase(movie)
        }
    }

}