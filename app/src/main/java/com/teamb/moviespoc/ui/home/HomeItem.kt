package com.teamb.moviespoc.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamb.moviespoc.R
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme


@Composable
fun HomeItem() {
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
                    .width(440.dp)
                    .background(Color.Black),
                contentScale = ContentScale.FillBounds,
                painter = painterResource(R.mipmap.placeholder),
                contentDescription = "Movie Preview",
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

            Text(modifier = Modifier
                .padding(top = 8.dp),
                text = "Title",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )

            Text(
                text = "Description",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }

}
@Preview(showBackground = true)
@Composable
fun HomeItemPreview() {
    MoviesPOCTheme {
        HomeItem()
    }
}