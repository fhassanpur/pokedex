package com.ferdows.pokedex.repository

import androidx.paging.PagingSource
import com.ferdows.pokedex.database.dao.PokemonDao
import com.ferdows.pokedex.database.model.PokemonEntity
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonDao: PokemonDao,
    val remoteMediator: PokemonRemoteMediator
) {
    val pagingSource: PagingSource<Int, PokemonEntity> = pokemonDao.getAll()
}