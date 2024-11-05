package com.fatec.cineapp.core.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun NavigationGraph(
    navController : NavHostController
){
    NavHost(
        navController = navController,
        startDestination = BottonNavItem.MoviePopular.route
    ){
        composable(BottonNavItem.MoviePopular.route){
            Text(text = "Filmes Populares")
        }


        composable(BottonNavItem.MovieSearch.route){
            Text(text = "Pesquisar")
        }

        composable(BottonNavItem.MovieFavorite.route){
            Text(text = "Favoritos")
        }

    }
}