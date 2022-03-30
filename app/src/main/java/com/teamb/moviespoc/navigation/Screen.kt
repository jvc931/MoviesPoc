package com.teamb.moviespoc.navigation


/*
*Screen
*
* Creator: Leoncio Chiunti
*/
sealed class Screen(val route: String) {
    object Splash : Screen(route = SPLASH_ROUTE)
    object Home : Screen(route = HOME_ROUTE)

    companion object{
        const val SPLASH_ROUTE = "splash_screen"
        const val HOME_ROUTE = "home_screen"
    }
}

