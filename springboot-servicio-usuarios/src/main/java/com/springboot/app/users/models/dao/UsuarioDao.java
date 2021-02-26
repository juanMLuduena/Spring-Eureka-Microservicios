package com.springboot.app.users.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.app.users.models.entity.Usuario;

@RepositoryRestResource(path="usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	
	public Usuario findByUsername(String username);
	
	@Query("select u from Usuario u where u.username = ?1")
	public Usuario obtenerPorUsername(String username);
}
