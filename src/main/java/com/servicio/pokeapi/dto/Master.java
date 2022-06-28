package com.servicio.pokeapi.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "master")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Master {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_master")
	private long id_master;
	@Column(name = "name")
	private String name;
	@Column(name = "hobby")
	private String hobby;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "document_name")
	private String document_name;
	@Column(name = "document_number")
	private String document_number;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "img_perfil", columnDefinition= "BLOB")
	private String img_perfil;
	
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
}
