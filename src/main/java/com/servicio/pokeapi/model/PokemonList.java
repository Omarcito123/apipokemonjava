package com.servicio.pokeapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PokemonList {
	private long count;
	private String next;
    private String previous;
    private List<PokemonURL> results;
    private List<Object> pokemon;
    
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<PokemonURL> getResults() {
		return results;
	}
	public void setResults(List<PokemonURL> results) {
		this.results = results;
	}
	public List<Object> getPokemon() {
		return pokemon;
	}
	public void setPokemon(List<Object> pokemon) {
		this.pokemon = pokemon;
	}
}
