package com.teamb.moviespoc.ui.favorites

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.ui.home.Movies
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FavoritesMovies(viewModel: FavoriteMoviesViewModel = hiltViewModel()) {
    val movies: List<PopularMovie> by viewModel.savedMovies.collectAsState(initial = emptyList())

    Movies(movies,selectedItem = {
    })
}