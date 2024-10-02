package com.minedu.project.maintenance_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1")
public class PrincipalController {
	
	@GetMapping("/Inicio")
	public String index() {
		return "Inicio";
	}
}
