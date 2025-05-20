package com.example.prueba_ordinario.pantallas

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    var pokemonList by mutableStateOf<List<Pokemon>>(emptyList())
        private set

    var isLoading by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.api.getPokemonList()
                Log.d("PokemonViewModel", "Respuesta cruda: $response")
                Log.d("PokemonViewModel", "Cantidad de pokemones: ${response.results.size}")
                pokemonList = response.results
            } catch (e: Exception) {
                Log.e("PokemonViewModel", "Error cargando pokemones: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
}
