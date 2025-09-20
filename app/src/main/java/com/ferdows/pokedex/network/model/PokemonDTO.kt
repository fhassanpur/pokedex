package com.ferdows.pokedex.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDTO (
    val id: Int,
    val name: String
)