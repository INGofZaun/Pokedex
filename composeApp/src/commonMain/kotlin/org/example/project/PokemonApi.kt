package org.example.project

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

object PokemonApi {
    suspend fun fetchPokemonList(): List<Pokemon> {
        val response: PokemonListResponse = httpClient.get("https://pokeapi.co/api/v2/pokemon?limit=100")
            .body()
        return response.results
    }
}
