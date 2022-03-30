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
}