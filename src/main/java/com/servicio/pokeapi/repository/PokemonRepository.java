package com.servicio.pokeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.servicio.pokeapi.dto.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
	@Procedure(value = "CreatePokemon")
	int CreatePokemon(long number_pokemon_pokeapi, String pokemon_name, String pokemon_type, long hp,
			long attack, long defense, long special_attack, long special_defense, long speed, String image);
	
	@Procedure(value = "GetMasterPokemon")
	List<Pokemon> GetMasterPokemon(long id_master);
	
	@Procedure(value = "UpdatePokemon")
	void UpdatePokemon(long id_pokemon_in, long number_pokemon_pokeapi, String pokemon_name, String pokemon_type, long hp,
			long attack, long defense, long special_attack, long special_defense, long speed, String image);
	
	@Procedure(value = "DeletePokemon")
	void DeletePokemon(long id_pokemon_in);
}
