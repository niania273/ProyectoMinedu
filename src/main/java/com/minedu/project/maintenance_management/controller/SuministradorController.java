package com.minedu.project.maintenance_management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.service.SuministradorService;


@Controller
@RequestMapping("/suministradores")
public class SuministradorController {
	
	@Autowired 
	private SuministradorService service;
	
	@GetMapping
	public String listSuministradores(Model model) {
		model.addAttribute("lstSuministradores", service.findAllSuministradores());
		return "Suministrador/Suministradores";
	}
	
	@GetMapping ("/registrar")
	public String showRegistrarSuministrador(Model model) {
		model.addAttribute("suministrador", new Suministrador());
		return "Suministrador/RegistrarSuministrador";
	}
	
	@GetMapping ("/editar/{id}")
	public String showEditarSuministrador(@PathVariable("id") String ID, Model model) {
		Suministrador suministrador = service.findSuministradorById(ID);
		model.addAttribute("suministrador", suministrador);
		return "Suministrador/EditarSuministrador";
	}
	
	@PostMapping("/actualizar")
	 public String actualizarSuministrador(@ModelAttribute("suministrador") Suministrador suministrador, Model model) {
		System.out.println("0");
		service.saveSuministradorById(suministrador);
        System.out.println("1");
        model.addAttribute("suministrador", suministrador);
        System.out.println("2");
        model.addAttribute("mensaje", "Datos actualizados correctamente");
        System.out.println("3");
        
        return "Suministrador/EditarSuministrador";
    }
	
}
