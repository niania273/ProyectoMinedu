package com.minedu.project.maintenance_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
public class RequerimientoController {
	
	@Autowired
	private RequerimientoService reqService;
	
	@Autowired
	private SolicitudService solService;
	
	
	@GetMapping("/requerimientos")
	public String requerimientos(Model model) {
		model.addAttribute("lstRequerimientos", reqService.findAllRequerimientos());
		return "Requerimientos";
	}
	
	@GetMapping("/requerimientos/generar")
	public String generarRequerimientos(Model model) {
		model.addAttribute("lstSolicitudes", solService.findAllSolicitudes());
			return "GenerarRequerimiento";
	}
	
	
}
