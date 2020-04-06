package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.uca.capas.domain.Usuario;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String enviarForm(Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/validation")
	public String procesarForm(Usuario usuario) {
		
		if(usuario.getUser().equals("admin") && usuario.getPassword().equals("admin")) {
			return "validation";
		}else {
			return "bad_validation";
		}
	}
	
}