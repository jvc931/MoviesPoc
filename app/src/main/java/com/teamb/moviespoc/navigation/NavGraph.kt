package com.teamb.moviespoc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teamb.moviespoc.AnimatedSplashScreen

/*
*NavGraph
*
* Creator: Leoncio Chiunti
*/
@Composable
fun SetUpNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = Screen.Splash.route){
        composable(route = Screen.Splash.route){
            AnimatedSplashScreen()
        }
    }
}