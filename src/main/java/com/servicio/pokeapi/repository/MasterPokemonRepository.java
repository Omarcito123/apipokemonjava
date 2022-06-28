package com.servicio.pokeapi.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.servicio.pokeapi.dto.Master_Pokemon;

public interface MasterPokemonRepository extends CrudRepository<Master_Pokemon, Long> {
	@Procedure(value = "CreateMasterPokemon")
	int CreateMasterPokemon(long id_master, long id_pokemon);
	
	@Procedure(value = "DeleteMasterPokemon")
	void DeleteMasterPokemon(long id_master_in, long id_pokemon_in);
}
