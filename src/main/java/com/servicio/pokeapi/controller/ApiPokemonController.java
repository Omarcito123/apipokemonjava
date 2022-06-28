package com.servicio.pokeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.pokeapi.dto.Master;
import com.servicio.pokeapi.dto.Pokemon;
import com.servicio.pokeapi.model.FullMasterPerfilObject;
import com.servicio.pokeapi.model.ResponseObject;
import com.servicio.pokeapi.service.ApiPokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class ApiPokemonController {

	@Autowired
	ApiPokemonService apiPokemonService;
	
	@PostMapping(path = "/login", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseObject login(Master master) {
		return apiPokemonService.login(master);
	}
	
	@PostMapping("/signup")
	public ResponseObject signup(@RequestBody FullMasterPerfilObject masterPerfil) {
		return apiPokemonService.signup(masterPerfil);
	}
	
	@PutMapping("/updateMasterPerfil/{id_master}")
	public ResponseObject updatePerfil(@RequestBody Master master, @PathVariable long id_master) {
		return apiPokemonService.updateMasterPerfil(id_master, master);
	}
	
	@PostMapping("/createPokemon/{id_master}")
	public ResponseObject createPokemon(@PathVariable long id_master, @RequestBody Pokemon pokemon) {
		return apiPokemonService.createPokemon(id_master, pokemon);
	}
	
	@PutMapping("/updatePokemon/{id_pokemon}")
	public ResponseObject updatePokemon(@RequestBody Pokemon pokemon, @PathVariable long id_pokemon) {
		return apiPokemonService.updatePokemon(id_pokemon, pokemon);
	}
	
	@GetMapping("/getMasterPokemon/{id_master}")
	public ResponseObject getMasterPokemon(@PathVariable long id_master) {
		return apiPokemonService.getMasterPokemon(id_master);
	}
	
	@DeleteMapping(value = "/deletePokemon/{id_master}/{id_pokemon}")
    public ResponseObject deletePokemon(@PathVariable long id_master, @PathVariable long id_pokemon) {
		return apiPokemonService.deletePokemon(id_master, id_pokemon);
    }
	
	@GetMapping("/getPokemonList")
	public ResponseObject getPokemonList(@RequestParam long offset, @RequestParam long limit) {
		return apiPokemonService.getPokemonList(limit, offset);
	}
}
