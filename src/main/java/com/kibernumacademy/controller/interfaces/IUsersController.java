package com.kibernumacademy.controller.interfaces;

import java.util.List;

import com.kibernumacademy.entity.Usuario;

public interface IUsersController {
	  public List<Usuario> findAllUsers();
}
