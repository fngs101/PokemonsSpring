package com.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class PokemonCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonCollectionApplication.class, args);
	}

}
