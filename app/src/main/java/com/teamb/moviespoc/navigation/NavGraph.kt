package com.teamb.moviespoc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teamb.moviespoc.AnimatedSplashScreen
import com.teamb.moviespoc.ui.about.About
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
            Home(navigationActions.navigateToAbout)
        }
        composable(route = Screen.Welcome.route) {
            Authenticate(navigationActions.navigateToHome, navigationActions.navigateToHome)
        }
        composable(route = Screen.About.route) {
            About(navigationActions.navigateToHome)
        }
    }
}