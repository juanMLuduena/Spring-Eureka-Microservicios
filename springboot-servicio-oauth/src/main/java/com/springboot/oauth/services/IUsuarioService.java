package com.springboot.oauth.services;

import com.springboot.commons.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
