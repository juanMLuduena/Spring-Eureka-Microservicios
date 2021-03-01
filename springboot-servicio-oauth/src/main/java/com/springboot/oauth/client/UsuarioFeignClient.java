package com.springboot.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.commons.models.entity.Usuario;

@FeignClient("servicio-usuarios")
public interface UsuarioFeignClient {

	
	@GetMapping("/usuarios/search/buscar-username")
	public Usuario findByUsername(@RequestParam("username") String username);
	
	@PutMapping("/usuarios/{id}")
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);
}
