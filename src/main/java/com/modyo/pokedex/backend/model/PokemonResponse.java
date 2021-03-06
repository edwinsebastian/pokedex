package com.modyo.pokedex.backend.model;

import lombok.Getter;
import lombok.Setter;
import me.sargunvohra.lib.pokekotlin.model.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PokemonResponse {
    private int id;
    private String name;
    private int height;
    private int weight;
    private List<String> abilities;
    private List<String> types;
    private String image;
    private String imageShiny;

    public PokemonResponse(Pokemon pokemon){
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.height = pokemon.getHeight();
        this.weight = pokemon.getWeight();
        this.abilities = getUtilData(pokemon.getAbilities());
        this.types = getUtilData(pokemon.getTypes());
        this.image = pokemon.getSprites().getFrontDefault();
        this.imageShiny = pokemon.getSprites().getFrontShiny();
    }

    private <E> List<String> getUtilData(List<E> eList){
        return eList
                .parallelStream()
                .map(e -> {
                    if(e instanceof  PokemonAbility){
                        return ((PokemonAbility) e).getAbility().getName();
                    }else if (e instanceof PokemonType){
                        return ((PokemonType) e).getType().getName();
                    }
                    return "";
                })
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities=" + abilities +
                ", types=" + types +
                ", image='" + image + '\'' +
                ", imageShiny='" + imageShiny + '\'' +
                '}';
    }
}