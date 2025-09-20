package com.ferdows.pokedex.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ferdows.pokedex.database.model.PokemonEntity
import com.ferdows.pokedex.model.Pokemon

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemonentity")
    fun getAll(): PagingSource<Int, PokemonEntity>

    @Insert
    fun insertAll(pokemon: List<Pokemon?>)
}