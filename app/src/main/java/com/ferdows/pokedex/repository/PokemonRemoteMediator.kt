package com.ferdows.pokedex.repository

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.ferdows.pokedex.database.dao.PokemonDao
import com.ferdows.pokedex.database.model.PokemonEntity
import com.ferdows.pokedex.model.Pokemon
import com.ferdows.pokedex.network.PokeAPIService
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator @Inject constructor(
    private val pokeAPIService: PokeAPIService,
    private val pokemonDao: PokemonDao
) : RemoteMediator<Int, PokemonEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PokemonEntity>
    ): MediatorResult {
        return try {
            val offset = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }

                    lastItem.id
                }
            }

            val response = pokeAPIService.pokemonList(offset = offset)
            val pokemonList = response.results.map { resource ->
                Pokemon(
                    id = resource.id ?: return@map null,
                    name = resource.name.capitalize(Locale.current)
                )
            }
            pokemonDao.insertAll(pokemonList)

            MediatorResult.Success(endOfPaginationReached = true)
        } catch (ex: Exception) {
            MediatorResult.Error(ex)
        }
    }

}