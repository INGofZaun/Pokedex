package org.example.project

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.example.project.model.PokemonDetail

class PokemonViewModel : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<PokemonDetail>>(emptyList())
    val pokemonList: StateFlow<List<PokemonDetail>> = _pokemonList

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        viewModelScope.launch {
            try {
                val pokemons = PokemonApi.fetchPokemonList()
                _pokemonList.value = pokemons
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
