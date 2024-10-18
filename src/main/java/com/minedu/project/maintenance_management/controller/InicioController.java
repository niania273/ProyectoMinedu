package com.minedu.project.maintenance_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping({"/", "/ingreso"})
	public String ingreso() {
		return "Ingreso";
	}
	
	@GetMapping("/inicio")
	public String inicio() {
		return "Inicio";
	}
	
	@GetMapping("/custom-login")
    public String mostrarLogin() {
        return "IniciarSesion";
    }
}
