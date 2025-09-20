package com.ferdows.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ferdows.pokedex.database.model.PokemonEntity

@Database(
    entities = [PokemonEntity::class],
    version = 1
)
abstract class PokedexDatabase : RoomDatabase() {

}