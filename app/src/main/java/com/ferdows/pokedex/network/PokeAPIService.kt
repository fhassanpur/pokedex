package com.ferdows.pokedex.network

import com.ferdows.pokedex.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokeAPIService {

    @GET("/pokemon/")
    suspend fun pokemonList(
        @Query("limit") limit: Int = 50,
        @Query("offset") offset: Int = 0
    ): PokemonListResponse

}