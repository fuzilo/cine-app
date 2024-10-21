package com.fatec.cineapp.core.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {
            Text(text = "Filmes Populares")

        }
        composable(BottomNavItem.MoviewSearch.route) {
            Text(text = "Pesquisar")
        }
        composable(BottomNavItem.MovieFavorite.route) {
        Text(text = "Favoritos")
        }
    }
}