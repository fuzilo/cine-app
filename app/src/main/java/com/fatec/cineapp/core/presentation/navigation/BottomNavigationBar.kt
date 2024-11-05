package com.fatec.cineapp.core.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fatec.cineapp.ui.theme.black
import com.fatec.cineapp.ui.theme.yellow

@Composable
fun BottomNavigationBar(
    navController: NavController
){
    val items = listOf(
        BottonNavItem.MovieFavorite,
        BottonNavItem.MovieSearch,
        BottonNavItem.MoviePopular
    )

    NavigationBar(
        contentColor = yellow,
        containerColor = black
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach{destination -> NavigationBarItem(
            selected = currentRoute == destination.route,
            onClick = {
            navController.navigate(destination.route){
                launchSingleTop = true
            }
                      },
            icon = {
                Icon(
                    imageVector = destination.icon,
                    contentDescription = null,
                    tint = yellow
                )
            },
            label = {
                Text(text = destination.title,
                    color = yellow)
            }
        )

        }
    }
}


@Preview
@Composable
fun BottomNavigationBarPreview(){
    BottomNavigationBar(navController = rememberNavController())
}