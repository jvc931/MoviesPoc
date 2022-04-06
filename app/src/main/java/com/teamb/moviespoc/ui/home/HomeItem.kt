package com.teamb.moviespoc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamb.moviespoc.domain.model.PopularMovie
import com.teamb.moviespoc.ui.favorites.FavoriteMoviesViewModel
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.teamb.moviespoc.ui.viewmodel.PopularViewModel

@Composable
fun HomeItem(homeItemClicked:(Int)-> Unit, movie: PopularMovie, favoriteMoviesViewModel: FavoriteMoviesViewModel = hiltViewModel()) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column {
            Image(
                modifier = Modifier
                    .height(500.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        movie.id?.let {
                           homeItemClicked.invoke(it)
                        }
                    }
                    .width(440.dp)
                    .background(Color.Black),
                contentScale = ContentScale.FillBounds,
                painter = rememberImagePainter(data = "https://image.tmdb.org/t/p/original/${movie.posterPath}"),
                contentDescription = movie.title,
            )

//            Row(
//                modifier = Modifier
//                    .padding(vertical = 8.dp)
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.End,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(Icons.Outlined.FavoriteBorder, "Love")
//            }

            Row {
                movie.title?.let {
                    Text(modifier = Modifier
                        .padding(top = 8.dp),
                        text = it,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h4,
                        color = Color.Black
                    )
                }
                IconButton({
                    favoriteMoviesViewModel.insert(movie)
                }) {
                    Icon(Icons.Outlined.Favorite, contentDescription = "")
                }
            }

            movie.overview?.let {
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun HomeItemPreview() {
    MoviesPOCTheme {
        //HomeItem(PopularMovie())
    }
}