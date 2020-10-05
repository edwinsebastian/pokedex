package com.modyo.pokedex.backend;

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokedexService {

    private final int QUERY_LIMIT = 20;

    @Autowired
    PokeApiClient pokeApiClient;

    List<Pokemon> getPokemonList(int offset) {
        NamedApiResourceList namedApiResourceList = pokeApiClient.getPokemonList(offset, QUERY_LIMIT);

        return namedApiResourceList
                .getResults()
                .parallelStream()
                .map(namedApiResource -> getPokemon(namedApiResource.getId()))
                .collect(Collectors.toList());
    }

    Pokemon getPokemon(int id){
        return pokeApiClient.getPokemon(id);
    }
}
