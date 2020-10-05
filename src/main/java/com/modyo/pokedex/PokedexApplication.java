package com.modyo.pokedex;

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PokedexApplication {

    @Bean
    PokeApiClient getPokeApiClient(){
        return new PokeApiClient();
    }

    public static void main(String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

}
