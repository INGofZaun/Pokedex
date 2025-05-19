package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.example.project.model.PokemonDetail
import org.example.project.ui.PokemonListItem


@Composable
fun PokedexApp() {
    val scope = rememberCoroutineScope()
    var pokemonList by remember { mutableStateOf<List<PokemonDetail>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        scope.launch {
            pokemonList = PokemonApi.fetchPokemonList()
            isLoading = false
        }
    }

    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(modifier = Modifier.padding(8.dp)) {
                    items(pokemonList) { pokemon ->
                        PokemonListItem(pokemon)
                    }
                }
            }
        }
    }
}
