package com.modyo.pokedex.backend.service;

import com.modyo.pokedex.backend.model.PokemonResponse;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokedexService {

    private final int QUERY_LIMIT = 20;

    @Autowired
    PokeApiClient pokeApiClient;

    @Cacheable("pokemon")
    public List<PokemonResponse> getPokemonResponseList(int offset) {
        NamedApiResourceList namedApiResourceList = pokeApiClient.getPokemonList(offset, QUERY_LIMIT);

        return namedApiResourceList
                .getResults()
                .parallelStream()
                .map(namedApiResource -> getPokemon(namedApiResource.getId()))
                .map(PokemonResponse::new)
                .collect(Collectors.toList());
    }

    public Pokemon getPokemon(int id){
        return pokeApiClient.getPokemon(id);
    }
}
