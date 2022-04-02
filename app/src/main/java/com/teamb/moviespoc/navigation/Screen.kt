package com.teamb.moviespoc.navigation


/*
*Screen
*
* Creator: Leoncio Chiunti
*/
sealed class Screen(val route: String) {
    object Splash : Screen(route = SPLASH_ROUTE)
    object Home : Screen(route = HOME_ROUTE)
    object Welcome : Screen(route = WELCOME_ROUTE)
    object About : Screen(route = ABOUT_ROUTE)
    object Favorites : Screen(route = FAVORITES_ROUTE)

    companion object{
        const val SPLASH_ROUTE = "splash_screen"
        const val HOME_ROUTE = "home_screen"
        const val WELCOME_ROUTE = "welcome_screen"
        const val ABOUT_ROUTE = "about_screen"
        const val FAVORITES_ROUTE = "favorites_screen"
    }
}

