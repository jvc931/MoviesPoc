package com.teamb.moviespoc.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.domain.usecase.GetSavedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
    private val getSavedMoviesUseCase: GetSavedMoviesUseCase,
): ViewModel(){
     // saved movies to use Flow
     lateinit var savedMovies : Flow<List<PopularMovie>>

    fun onCreate(){
        viewModelScope.launch(Dispatchers.IO) {
            savedMovies = getSavedMoviesUseCase()
        }
    }
}