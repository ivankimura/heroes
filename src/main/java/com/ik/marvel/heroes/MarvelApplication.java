package com.ik.marvel.heroes;

import com.ik.marvel.heroes.services.CharacterService;
import com.ik.marvel.heroes.services.CharacterServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApplication.class, args);

	}

}
