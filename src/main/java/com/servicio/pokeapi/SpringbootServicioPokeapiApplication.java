package com.servicio.pokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootServicioPokeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioPokeapiApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
	   return new RestTemplate();
	}
}
