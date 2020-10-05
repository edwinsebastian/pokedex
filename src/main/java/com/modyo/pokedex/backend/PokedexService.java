package com.modyo.pokedex.backend;

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokedexService {

    private final int QUERY_LIMIT = 20;

    @Autowired
    PokeApiClient pokeApiClient;

    NamedApiResourceList getPokemonList(int offset){
        return pokeApiClient.getPokemonList(offset, QUERY_LIMIT);
    }

    Pokemon getPokemon(int id){
        return pokeApiClient.getPokemon(id);
    }
}
