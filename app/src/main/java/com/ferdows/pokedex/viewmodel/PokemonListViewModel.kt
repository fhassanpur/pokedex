package com.ferdows.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.ferdows.pokedex.model.Pokemon
import com.ferdows.pokedex.repository.PokemonRepository
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(pageSize = 50),
        remoteMediator = repository.remoteMediator,
    ) {
        repository.pagingSource
    }

    val flow = pager.flow.map { pagingData ->
        pagingData.map {
            Pokemon(it)
        }
    }.cachedIn(viewModelScope)
}