package com.modyo.pokedex;

import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class PokedexApplication {

    @Bean
    PokeApiClient getPokeApiClient(){
        return new PokeApiClient();
    }

    public static void main(String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

}
