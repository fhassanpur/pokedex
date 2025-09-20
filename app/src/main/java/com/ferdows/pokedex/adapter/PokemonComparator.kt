package com.ferdows.pokedex.adapter

import androidx.recyclerview.widget.DiffUtil
import com.ferdows.pokedex.model.Pokemon

object PokemonComparator : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}