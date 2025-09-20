package com.ferdows.pokedex.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonEntity (
    @PrimaryKey val id: Int,
    val name: String
)