package com.teamb.moviespoc.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme
import com.teamb.moviespoc.ui.theme.Purple500
import com.teamb.moviespoc.ui.viewmodel.PopularViewModel

@Composable
fun Home(viewModel: PopularViewModel = hiltViewModel()) {

    val movies: List<PopularMovie> by viewModel.popularMovies.collectAsState(initial = emptyList())
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* ... */ },
                backgroundColor = Purple500,
            ) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                backgroundColor = Purple500,
                // Defaults to null, that is, No cutout
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {
                // Leading icons should typically have a high content alpha
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "Home section", tint = Color.White)
                    }
                }
                // The actions should be at the end of the BottomAppBar. They use the default medium
                // content alpha provided by BottomAppBar
                Spacer(Modifier.weight(1f, true))
//                IconButton(onClick = { /* doSomething() */ }) {
//                    Icon(Icons.Filled.Favorite, contentDescription = "Localized description", tint = Color.White)
//                }
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Person, contentDescription = "Profile", tint = Color.White)
                }
            }
        }
    ) {
        Movies(movies)
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    MoviesPOCTheme {
        Home()
    }
}
