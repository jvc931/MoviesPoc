package com.teamb.moviespoc.navigation

import androidx.navigation.NavHostController

class NavActions(navController: NavHostController) {

    val navigateToHome: () -> Unit = {
        navController.navigate(Screen.DetailScreen.route) {
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
}