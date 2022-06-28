package com.servicio.pokeapi.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.servicio.pokeapi.dto.Pokemon;

public class FullMasterPerfilObject {
	private long id_master;
	private String name;
	private String hobby;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthday;
	private String document_name;
	private String document_number;
	private String username;
	private String password;
	private String img_perfil;
	private List<Pokemon> pokemonList;
	
	public long getId_master() {
		return id_master;
	}
	public void setId_master(long id_master) {
		this.id_master = id_master;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDocument_name() {
		return document_name;
	}
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	public String getDocument_number() {
		return document_number;
	}
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	public String getImg_perfil() {
		return img_perfil;
	}
	public void setImg_perfil(String img_perfil) {
		this.img_perfil = img_perfil;
	}
	public List<Pokemon> getPokemonList() {
		return pokemonList;
	}
	public void setPokemonList(List<Pokemon> pokemonList) {
		this.pokemonList = pokemonList;
	}
}
