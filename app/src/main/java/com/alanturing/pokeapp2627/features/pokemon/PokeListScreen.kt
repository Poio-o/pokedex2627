package com.alanturing.pokeapp2627.features.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.ViewModel

@Composable
fun PokeListScreen(viewModel: ViewModel = hiltViewModel()) {
    Column() {
        Text("PokeList")
    }
}