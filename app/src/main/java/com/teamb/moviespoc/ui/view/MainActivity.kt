package com.teamb.moviespoc.ui.view
/**
 * Created by Jonathan Guerrero on 3/28/22.
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.teamb.moviespoc.navigation.SetUpNavGraph
import androidx.activity.viewModels
import coil.annotation.ExperimentalCoilApi
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
            MoviesPOCTheme {
              SetUpNavGraph(navController = rememberNavController())
            }
        }
        popularViewModel.onCreate()
    }
}
