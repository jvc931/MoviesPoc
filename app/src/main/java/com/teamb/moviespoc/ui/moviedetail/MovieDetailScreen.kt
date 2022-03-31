package com.teamb.moviespoc.ui.moviedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.teamb.moviespoc.domain.model.Cast
import com.teamb.moviespoc.ui.viewmodel.PopularViewModel

@Preview(showBackground = true)
@Composable
fun MovieDetail(viewModel: PopularViewModel = hiltViewModel()) {

    //viewModel.getMovieDetail(508947)
    val movieDetail = viewModel.movie

    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Image(
                modifier = Modifier
                    .height(500.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .width(440.dp)
                    .background(Color.Black),
                contentScale = ContentScale.FillBounds,
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/original/${movieDetail.value.posterPath}"),
                contentDescription = movieDetail.value.title,
            )
            val genres = movieDetail.value.genres.map { it.name }

            Text(
                text = genres.toString() ?: "", style = MaterialTheme.typography.caption,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )


            Text(
                text = movieDetail.value.overview ?: "",
                textAlign = TextAlign.Justify,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Score: ${movieDetail.value.voteAverage}",
                textAlign = TextAlign.Justify,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Casting", style = MaterialTheme.typography.h5,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Box() {
                viewModel.onCreate()
                val movieCast = viewModel.castList.value
                ActorsList(movieCast)
            }
            Box {
                Text(text = "Youtube video")
            }
        }
    }
}


@Composable
fun ActorsList(movies: List<Cast>) {

    val swipeRefreshState = rememberSwipeRefreshState(false)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = { /* todo */ },
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                // Pass the SwipeRefreshState + trigger through
                state = state,
                refreshTriggerDistance = trigger,
                // Enable the scale animation
                scale = true,
                // Change the color and shape
                backgroundColor = MaterialTheme.colors.primary,
                shape = MaterialTheme.shapes.small,
            )
        }
    ) {
        LazyRow(modifier = Modifier.padding(bottom = 60.dp)) {
            items(movies) { movie ->
                ActorItem(movie)
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ActorItem(actor: Cast) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .width(220.dp)
                    .background(Color.Black),
                contentScale = ContentScale.FillBounds,
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/original/${actor.profilePath}"),
                contentDescription = actor.name,
            )


            Text(
                modifier = Modifier
                    .padding(top = 8.dp),
                text = actor.name ?: "",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )

            Text(
                text = actor.character ?: "",
                textAlign = TextAlign.Center,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Popularity: ${actor.popularity}",
                textAlign = TextAlign.Center,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}



