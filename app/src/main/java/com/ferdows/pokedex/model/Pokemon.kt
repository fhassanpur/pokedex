package com.ferdows.pokedex.model

import com.ferdows.pokedex.database.model.PokemonEntity
import com.ferdows.pokedex.network.model.PokemonDTO

data class Pokemon (
    val id: Int,
    val name: String
) {
    constructor(dto: PokemonDTO) : this(id = dto.id, name = dto.name)
    constructor(entity: PokemonEntity) : this(id = entity.id, name = entity.name)

    fun toEntity() = PokemonEntity(
        id = id,
        name = name
    )
}