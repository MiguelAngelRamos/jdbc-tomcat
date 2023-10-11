package com.kibernumacademy.controller;

import java.util.List;

import com.kibernumacademy.controller.interfaces.IUsersController;
import com.kibernumacademy.entity.Usuario;
import com.kibernumacademy.service.UsuariosService;

public class UserController implements IUsersController{
	
	UsuariosService usuarioService = new UsuariosService();

	@Override
	public List<Usuario> findAllUsers() {
		return usuarioService.findAllUsers();
	}

}
