package com.ferdows.pokedex.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokeApiResource (
    val name: String,
    val url: String
) {
    val id: Int?
        get() {
            return url.split("/").lastOrNull {
                it.isNotEmpty()
            }?.toIntOrNull()
        }
}