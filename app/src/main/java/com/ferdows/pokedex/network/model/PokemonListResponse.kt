package com.ferdows.pokedex.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonListResponse (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokeApiResource>
)