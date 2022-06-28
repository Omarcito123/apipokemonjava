package com.servicio.pokeapi.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicio.pokeapi.model.PokemonList;
import com.servicio.pokeapi.model.PokemonURL;

@Service
public class PokeApiRepository  {
	
	@Value("${url.pokeapi}")
    private String urlPokeApi;
	
	@Autowired
	RestTemplate restTemplate;
	
	public PokemonList getPokemonList(long limit, long offset) {
		List<Object> dataPokeList = new ArrayList<Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "updated-Value");
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    String url = urlPokeApi + "?limit=" + limit + "&offset=" + offset;
	    PokemonList pokeList = restTemplate.exchange(url, HttpMethod.GET, entity, PokemonList.class).getBody();
	    if(pokeList != null) {
	    	if(pokeList.getResults() != null) {
	    		pokeList.getResults().forEach((PokemonURL pokemonurl) -> {
	    			Object dataPokemon = restTemplate.exchange(pokemonurl.getUrl(), HttpMethod.GET, entity, Object.class).getBody();
	    			dataPokeList.add(dataPokemon);
	    		});
		    }
	    }
	    pokeList.setPokemon(dataPokeList);
		
	    return pokeList;
	}
}