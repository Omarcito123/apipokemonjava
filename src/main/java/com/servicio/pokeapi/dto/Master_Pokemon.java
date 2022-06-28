package com.servicio.pokeapi.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "master_pokemon")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Master_Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_master_pokemon")
	private long id_master_pokemon;
	@Column(name = "id_master")
	private long id_master;
	@Column(name = "id_pokemon")
	private long id_pokemon;
	
	public long getId_master_pokemon() {
		return id_master_pokemon;
	}
	public void setId_master_pokemon(long id_master_pokemon) {
		this.id_master_pokemon = id_master_pokemon;
	}
	public long getId_master() {
		return id_master;
	}
	public void setId_master(long id_master) {
		this.id_master = id_master;
	}
	public long getId_pokemon() {
		return id_pokemon;
	}
	public void setId_pokemon(long id_pokemon) {
		this.id_pokemon = id_pokemon;
	}
}
