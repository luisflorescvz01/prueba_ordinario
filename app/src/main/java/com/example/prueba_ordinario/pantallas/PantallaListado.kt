package com.example.prueba_ordinario.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun PantallaListado(navController: NavHostController) {
    val viewModel = PokemonViewModel()
    val pokemonList = viewModel.pokemonList

        LaunchedEffect(viewModel.pokemonList) {
            Log.d("PantallaListado", "Renderizando lista con ${viewModel.pokemonList.size} pokemones")
        }

        Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Button(
                onClick = {
                    navController.navigate("pantallaInicial")
                },
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text("Regresar", color = Color.White)
            }
                LazyColumn {
                    items(viewModel.pokemonList) { pokemon ->
                        Text(
                            text = pokemon.name.replaceFirstChar { it.uppercase() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }



