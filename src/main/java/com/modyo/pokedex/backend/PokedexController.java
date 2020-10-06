package com.modyo.pokedex.backend;

import com.modyo.pokedex.backend.model.PokemonResponse;
import me.sargunvohra.lib.pokekotlin.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pokedex")
public class PokedexController {

    @Autowired
    PokedexService pokedexService;

    @GetMapping("/list")
    List<PokemonResponse> getPokemonList(@RequestParam Optional<Integer> offset){
        return pokedexService.getPokemonResponseList(offset.orElse(0));
    }

    @GetMapping("/pokemon/{id}")
    Pokemon getPokemon(@PathVariable("id") int id){
        return pokedexService.getPokemon(id);
    }

}
