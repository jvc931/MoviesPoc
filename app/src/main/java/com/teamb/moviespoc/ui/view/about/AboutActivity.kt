package com.teamb.moviespoc.ui.view.about

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme
import com.teamb.moviespoc.R

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesPOCTheme {
                Main()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun Main() {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar()
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "logo",
                    modifier = Modifier.padding(0.dp, 16.dp, 0.dp, 16.dp)
                )
                Text(
                    text = "Team",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                )
                MembersList()
            }
        }
    }

    @Composable
    fun TopAppBar() {
        TopAppBar(
            title = {
                Text(text = "About")
            },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
            }
        )
    }

    private data class Member(val name: String, val position: String, val imageId: Int)

    private val membersList = listOf(
        Member("Jonathan Vargas", "Android Developer", R.drawable.nick_fury),
        Member("Jonathan Guerrero", "Android Developer", R.drawable.spiderman),
        Member("Karen Barreto", "Android Developer", R.drawable.wonder_woman),
        Member("Leoncio Chiunti", "Android Developer", R.drawable.batman),
        Member("Christian Cagide", "Android Developer", R.drawable.captain_america)
    )

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun MembersList() {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            itemsIndexed(membersList) { _, item ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = item.imageId),
                        contentDescription = "img"
                    )
                    Text(
                        text = item.name,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    )
                    Text(text = item.position, modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp))
                }
            }
        }
    }
}