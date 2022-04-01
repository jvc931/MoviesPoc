package com.teamb.moviespoc.ui.view
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.teamb.moviespoc.navigation.SetUpNavGraph
import com.teamb.moviespoc.ui.theme.MoviesPOCTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesPOCTheme {
              SetUpNavGraph(navController = rememberNavController())
            }
        }
    }
}
