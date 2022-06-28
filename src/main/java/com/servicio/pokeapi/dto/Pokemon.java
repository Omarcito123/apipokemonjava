package com.servicio.pokeapi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pokemon")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pokemon")
	private long id_pokemon;
	@Column(name = "number_pokemon_pokeapi")
	private long number_pokemon_pokeapi;
	@Column(name = "name")
	private String name;	
	@Column(name = "pokemon_type")
	private String pokemon_type;	
	@Column(name = "hp")
	private long hp;
	@Column(name = "attack")
	private long attack;	
	@Column(name = "defense")
	private long defense;
	@Column(name = "special_attack")
	private long special_attack;
	@Column(name = "special_defense")
	private long special_defense;
	@Column(name = "speed")
	private long speed;
	@Column(name = "image")
	private String image;
	
	public long getId_pokemon() {
		return id_pokemon;
	}
	public void setId_pokemon(long id_pokemon) {
		this.id_pokemon = id_pokemon;
	}
	public long getNumber_pokemon_pokeapi() {
		return number_pokemon_pokeapi;
	}
	public void setNumber_pokemon_pokeapi(long number_pokemon_pokeapi) {
		this.number_pokemon_pokeapi = number_pokemon_pokeapi;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPokemon_type() {
		return pokemon_type;
	}
	public void setPokemon_type(String pokemon_type) {
		this.pokemon_type = pokemon_type;
	}
	public long getHp() {
		return hp;
	}
	public void setHp(long hp) {
		this.hp = hp;
	}
	public long getAttack() {
		return attack;
	}
	public void setAttack(long attack) {
		this.attack = attack;
	}
	public long getDefense() {
		return defense;
	}
	public void setDefense(long defense) {
		this.defense = defense;
	}
	public long getSpecial_attack() {
		return special_attack;
	}
	public void setSpecial_attack(long special_attack) {
		this.special_attack = special_attack;
	}
	public long getSpecial_defense() {
		return special_defense;
	}
	public void setSpecial_defense(long special_defense) {
		this.special_defense = special_defense;
	}
	public long getSpeed() {
		return speed;
	}
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
