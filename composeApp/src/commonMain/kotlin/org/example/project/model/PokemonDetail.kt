package org.example.project.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetail(
    val id: Int,
    val name: String,
    val sprites: Sprites
)

@Serializable
data class Sprites(
    @SerialName("front_default") val frontDefault: String?
)
