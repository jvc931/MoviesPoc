package com.teamb.moviespoc.ui.view
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme
import com.teamb.moviespoc.ui.viewmodel.PopularViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val popularViewModel: PopularViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //using livedata
            //val movies = popularViewModel.popularMovies.value
            //using flow
            val movies: List<PopularMovie> by popularViewModel.popularMovies.collectAsState(initial = emptyList())

            val movieDetail = popularViewModel.movie.value
            Log.i("TEST: ", "Movies: $movies")
            Log.i("TEST: ", "Movie Detail: $movieDetail")

            MoviesPOCTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MoviesList(movies)
                    }
                }
            }
        }
        popularViewModel.onCreate()
    }


    @Composable
    fun Greeting() {
        Text(text = "Movies POC", style = MaterialTheme.typography.h2)
    }

    //@Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MoviesPOCTheme {
            Greeting()
        }
    }

    @ExperimentalCoilApi
    @Composable
    fun MoviesList(movies: List<PopularMovie>) {
        LazyColumn() {
            items(items = movies){movie->
                MovieItem(movie)
            }
        }
    }


}
@ExperimentalCoilApi
//@Preview(showBackground = true)
@Composable
fun MovieItem(movie: PopularMovie) {
    Column() {
        Box(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/original/${movie.posterPath}"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Text(text = movie.originalTitle ?: "No tittle")
        }

    }
}
