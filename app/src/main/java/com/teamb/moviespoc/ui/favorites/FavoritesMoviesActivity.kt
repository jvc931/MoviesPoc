package com.teamb.moviespoc.ui.favorites

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.ui.home.Movies
import kotlinx.coroutines.flow.MutableStateFlow

class FavoritesMoviesActivity : ComponentActivity() {

    private val viewModel: FavoriteMoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        viewModel.onCreate()

        setContent {
            val movies: List<PopularMovie> by viewModel.savedMovies.collectAsState(initial = emptyList())
            Movies(cards = listOf(1,2,3,4,5))
        }
    }
}