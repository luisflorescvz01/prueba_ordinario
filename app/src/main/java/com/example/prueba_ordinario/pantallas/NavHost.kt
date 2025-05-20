package com.example.prueba_ordinario.pantallas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "pantallaInicial") {
        composable("pantallaInicial") {
            PantallaInicial(navController)
        }
        composable("pantallaListado") {
            PantallaListado(navController)
        }
        composable("pantallaGameOver") {
            PantallaGameOver(navController)
        }
    }
}
