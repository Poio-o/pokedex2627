package com.alanturing.pokeapp2627.features.pokemon.data.remote

import com.alanturing.pokeapp2627.features.pokemon.data.model.Pokemon
import javax.inject.Inject

class PokemonRemoteDataSource
    @Inject constructor(
        private val _api:PokeApi
    ): PokemonDataSource {
    override suspend fun readAllPokemon(): List<Pokemon> {
        val response = _api.readAllPokemon()
        val pokemons = mutableListOf<Pokemon>()
        if (response.isSuccessful) {
            val body = response.body()!!
            for(item in body.results) {
                val pokemon = readPokemonByName(item.name)
                if (pokemon != null) {
                    pokemons.add(pokemon)
                }
            }
        }
        else {
            throw Exception("Error al obtener la lista")
        }
        return pokemons
    }

    override suspend fun readPokemonByName(name: String): Pokemon? {
        val response = _api.readPokemonByName(name)
        if (response.isSuccessful) {
            val body = response.body()!!
            return body.toModel()
        }
        else{
            return null
        }
    }

    override suspend fun readPokemonById(id: Int): Pokemon {
        TODO("Not yet implemented")
    }

}