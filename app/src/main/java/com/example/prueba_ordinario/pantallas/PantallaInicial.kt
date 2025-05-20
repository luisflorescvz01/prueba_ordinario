package com.example.prueba_ordinario.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun PantallaInicial(navController: NavHostController) {
    var input by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("¿Opción a probar?")

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = input,
                onValueChange = {
                    input = it
                    showError = false
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (input == "1") {
                        navController.navigate("pantallaListado")

                    } else if (input == "2") {
                        navController.navigate("pantallaGameOver")
                    } else {
                        showError = true
                    }
                },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text("Validar", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (showError) {
                Text(
                    "Por favor ingrese uno de estos números: 1, 2",
                    color = Color.Red,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }

        Text(
            "Luis Flores ID20104",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}