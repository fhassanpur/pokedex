package com.ferdows.pokedex.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PokemonListScreen(pokemon: List<String>) {
    LazyColumn {
        items(pokemon) { pkmn ->
            Text(text = pkmn)
        }
    }
}