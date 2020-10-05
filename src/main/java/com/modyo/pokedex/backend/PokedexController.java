package com.modyo.pokedex.backend;

import me.sargunvohra.lib.pokekotlin.model.NamedApiResourceList;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/pokedex")
public class PokedexController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping("/list")
    NamedApiResourceList getPokemonList(@RequestParam Optional<Integer> offset){
        return pokedexService.getPokemonList(offset.orElse(0));
    }

    @GetMapping("/pokemon/{id}")
    Pokemon getPokemon(@PathVariable("id") int id){
        return pokedexService.getPokemon(id);
    }

}
