package com.fatec.cineapp.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.fatec.cineapp.core.presentation.navigation.BottomNavigationBar
import com.fatec.cineapp.core.presentation.navigation.NavigationGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavHostController
){
    Scaffold(
        Modifier.padding(top= 16.dp),
        content = {
            NavigationGraph(navController = navController)
        },
        bottomBar ={
            BottomNavigationBar(navController = navController)

        }
    )
}