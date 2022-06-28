package com.servicio.pokeapi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.servicio.pokeapi.dto.Master;

public interface MasterRepository extends CrudRepository<Master, Long> {
	@Procedure(value = "CheckUser")
	Master login(String username, String password);
	
	@Procedure(value = "CreateMaster")
	int CreateMaster(Date birthday, String document_name, String document_number, String hobby,
			String name_user, String password_user, String username, String img_perfil);
	
	@Procedure(value = "UpdateMaster")
	void UpdateMaster(long id_master_in, Date birthday, String document_name, String document_number, String hobby,
			String name_user, String username_in, String img_perfil);
}