package com.teamb.moviespoc.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.teamb.moviespoc.AnimatedSplashScreen
import com.teamb.moviespoc.ui.about.About
import com.teamb.moviespoc.ui.favorites.FavoritesMovies
import com.teamb.moviespoc.ui.home.Home
import com.teamb.moviespoc.ui.welcome.Authenticate

/*
*NavGraph
*
* Creator: Leoncio Chiunti
*/
@Composable
fun SetUpNavGraph(navController: NavHostController){
    val navigationActions =  NavActions(
        navController
    )

    NavHost(navController = navController,
        startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            AnimatedSplashScreen(navigationActions.navigateToWelcome)
        }
        composable(route = Screen.Home.route) {
            Home(onAboutClicked = navigationActions.navigateToAbout, onFavoritesClicked = navigationActions.navigateToFavorites)
        }
        composable(route = Screen.Welcome.route) {
            Authenticate(navigationActions.navigateToHome, navigationActions.navigateToHome)
        }
        composable(
            route = Screen.DetailScreen.route.plus("/{movieId}"),
            arguments = listOf(
            navArgument("movieId") { type = NavType.IntType }
        )
        ) { backStackEntry ->
            val movieId =
                backStackEntry.arguments?.getInt("movieId") ?: return@composable
            MovieDetail(viewModel = hiltViewModel(), movieId = movieId)

        composable(route = Screen.About.route) {
            About(navigationActions.navigateToHome)
        }
        composable(route = Screen.Favorites.route) {
            FavoritesMovies()
        }
    }
}