package com.example.prueba_ordinario.pantallas

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokeApiService {
    @GET("pokemon?limit=151")
    suspend fun getPokemonList(): PokemonResponse
}

object RetrofitClient {
    val api: PokeApiService = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PokeApiService::class.java)
}

