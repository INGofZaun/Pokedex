package org.example.project

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.example.project.model.PokemonDetail
import org.example.project.model.PokemonListResponse

object PokemonApi {
    private val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun fetchPokemonList(): List<PokemonDetail> {
        val listResponse: PokemonListResponse = client.get("https://pokeapi.co/api/v2/pokemon?limit=20").body()
        return listResponse.results.mapNotNull { item ->
            runCatching {
                client.get(item.url).body<PokemonDetail>()
            }.getOrNull()
        }
    }
}
