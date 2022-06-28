package com.servicio.pokeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicio.pokeapi.dto.Master;
import com.servicio.pokeapi.dto.Pokemon;
import com.servicio.pokeapi.interfaces.ApiPokemonInterface;
import com.servicio.pokeapi.model.FullMasterPerfilObject;
import com.servicio.pokeapi.model.PokemonList;
import com.servicio.pokeapi.model.ResponseObject;
import com.servicio.pokeapi.repository.MasterPokemonRepository;
import com.servicio.pokeapi.repository.MasterRepository;
import com.servicio.pokeapi.repository.PokeApiRepository;
import com.servicio.pokeapi.repository.PokemonRepository;

@Service
@Transactional
public class ApiPokemonService implements ApiPokemonInterface {
	
	@Autowired
	MasterRepository masterRepository;
	
	@Autowired
	MasterPokemonRepository masterPokemonRepository;
	
	@Autowired
	PokemonRepository pokemonRepository;
	
	@Autowired
	PokeApiRepository pokeApiRepository;

	@Override
	public ResponseObject login(Master master) {
		ResponseObject response = new ResponseObject();
		try {
			Master userMaster = masterRepository.login(master.getUsername(), master.getPassword());
			if(userMaster != null) {
				response.setState("Success");
				response.setSuccess(true);
			}else {
				response.setState("Error");
				response.setSuccess(false);
				response.setMessage("Usuario o contraseña incorrecta");
			}			
			response.setData(userMaster);
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject deletePokemon(long id_master, long id_pokemon) {
		ResponseObject response = new ResponseObject();
		try {
			masterPokemonRepository.DeleteMasterPokemon(id_master, id_pokemon);
			pokemonRepository.DeletePokemon(id_pokemon);
			response.setState("Success");
			response.setSuccess(true);
			response.setMessage("Pokemon eliminado correctamente");
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject getMasterPokemon(long id_master) {
		ResponseObject response = new ResponseObject();
		try {
			List<Pokemon> pokemonList = pokemonRepository.GetMasterPokemon(id_master);
			if(pokemonList != null) {
				response.setState("Success");
				response.setSuccess(true);
				response.setMessage("Pokemon obtenidos correctamente");
				response.setData(pokemonList);
			} else {
				response.setState("Error");
				response.setSuccess(false);
				response.setMessage("Error al obtener los pokemon");
			}
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject createPokemon(long id_master, Pokemon pokemon) {
		ResponseObject response = new ResponseObject();
		try {
			int pokemonId = pokemonRepository.CreatePokemon(pokemon.getNumber_pokemon_pokeapi(), pokemon.getName(), pokemon.getPokemon_type(), pokemon.getHp(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecial_attack(), pokemon.getSpecial_defense(), pokemon.getSpeed(), pokemon.getImage());
			if(pokemonId != 0) {
				int masterPokemonId = masterPokemonRepository.CreateMasterPokemon(id_master, pokemonId);
            	if(masterPokemonId != 0) {
            		response.setState("Success");
        			response.setSuccess(true);
        			response.setMessage("Pokemon guardar correctamente");
				} else {
					response.setState("Error");
					response.setSuccess(false);
					response.setMessage("Error al guardar el pokemon");
				}
			} else {
				response.setState("Error");
				response.setSuccess(false);
				response.setMessage("Error al guardar el pokemon");
			}
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject updateMasterPerfil(long id_master, Master master) {
		ResponseObject response = new ResponseObject();
		try {
			masterRepository.UpdateMaster(id_master, master.getBirthday(), master.getDocument_name(), master.getDocument_number(), master.getHobby(), master.getName(), master.getUsername(), master.getImg_perfil());
			response.setState("Success");
			response.setSuccess(true);
			response.setMessage("Perfil actualizado correctamente");
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject updatePokemon(long id_pokemon, Pokemon pokemon) {
		ResponseObject response = new ResponseObject();
		try {
			pokemonRepository.UpdatePokemon(id_pokemon, pokemon.getNumber_pokemon_pokeapi(), pokemon.getName(), pokemon.getPokemon_type(), pokemon.getHp(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecial_attack(), pokemon.getSpecial_defense(), pokemon.getSpeed(), pokemon.getImage());
			response.setState("Success");
			response.setSuccess(true);
			response.setMessage("Pokemon actualizado correctamente");
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject signup(FullMasterPerfilObject masterPerfil) {
		ResponseObject response = new ResponseObject();
		try {
			int masterId = masterRepository.CreateMaster(masterPerfil.getBirthday(), masterPerfil.getDocument_name(), masterPerfil.getDocument_number(), masterPerfil.getHobby(), masterPerfil.getName(), masterPerfil.getPassword(), masterPerfil.getUsername(), masterPerfil.getImg_perfil());
			if(masterId != 0) {
				masterPerfil.getPokemonList().forEach((Pokemon pokemon) -> {
		            int pokemonId = pokemonRepository.CreatePokemon(pokemon.getNumber_pokemon_pokeapi(), pokemon.getName(), pokemon.getPokemon_type(), pokemon.getHp(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getSpecial_attack(), pokemon.getSpecial_defense(), pokemon.getSpeed(), pokemon.getImage());
		            if(pokemonId != 0) {
		            	int masterPokemonId = masterPokemonRepository.CreateMasterPokemon(masterId, pokemonId);
		            	if(masterPokemonId != 0) {
		            		response.setState("Success");
		        			response.setSuccess(true);
		        			response.setMessage("Perfil creado correctamente");
						} else {
							response.setState("Error");
							response.setSuccess(false);
							response.setMessage("Error al guardar el perfil");
						}
					} else {
						response.setState("Error");
						response.setSuccess(false);
						response.setMessage("Error al guardar el perfil");
					}
		        });
			} else {
				response.setState("Error");
				response.setSuccess(false);
				response.setMessage("Error al guardar el perfil");
			}
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public ResponseObject getPokemonList(long limit, long offset) {
		ResponseObject response = new ResponseObject();
		try {
			PokemonList pokemonList = pokeApiRepository.getPokemonList(limit, offset);
			response.setState("Success");
			response.setSuccess(true);
			response.setMessage("Pokemon obtenidos correctamente");
			response.setData(pokemonList);
		} catch(Exception e) {
			response.setState("Error");
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
