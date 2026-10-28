package com.alanturing.pokeapp2627.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {

@Serializable
object PokeList : Routes("pokelist")

@Serializable
class PokeDetail(val pokemonID:Int) : Routes("pokedetail/${pokemonID}")
    }