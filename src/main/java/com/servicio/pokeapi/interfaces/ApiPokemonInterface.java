package com.servicio.pokeapi.interfaces;

import com.servicio.pokeapi.dto.Master;
import com.servicio.pokeapi.dto.Pokemon;
import com.servicio.pokeapi.model.FullMasterPerfilObject;
import com.servicio.pokeapi.model.ResponseObject;

public interface ApiPokemonInterface {
	public ResponseObject login(Master master);
	public ResponseObject deletePokemon(long id_master, long id_pokemon);
	public ResponseObject getMasterPokemon(long id_master);
	public ResponseObject createPokemon(long id_master, Pokemon pokemon);
	public ResponseObject updateMasterPerfil(long id_master, Master master);
	public ResponseObject updatePokemon(long id_pokemon, Pokemon pokemon);
	public ResponseObject signup(FullMasterPerfilObject masterPerfil);
	public ResponseObject getPokemonList(long limit, long offset);
}
