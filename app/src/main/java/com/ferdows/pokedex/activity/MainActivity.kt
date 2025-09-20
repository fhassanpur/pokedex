package com.ferdows.pokedex.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ferdows.pokedex.ui.theme.PokedexTheme
import com.ferdows.pokedex.view.PokemonListScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                val array = (0..1000).toList().map { it.toString() }
                PokemonListScreen(array)
            }
        }
    }

}