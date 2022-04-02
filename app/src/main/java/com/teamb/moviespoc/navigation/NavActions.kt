package com.teamb.moviespoc.navigation

import androidx.navigation.NavHostController

class NavActions(navController: NavHostController) {

    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.Home.route) {
            popUpTo(0) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToWelcome: () -> Unit = {
        navController.navigate(Screen.Welcome.route) {
            popUpTo(0) {
                saveState = false
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToAbout: () -> Unit = {
        navController.navigate(Screen.About.route) {
            launchSingleTop = true
        }
    }

    val navigateToFavorites: () -> Unit = {
        navController.navigate(Screen.Favorites.route) {
            launchSingleTop = true
        }
    }
}