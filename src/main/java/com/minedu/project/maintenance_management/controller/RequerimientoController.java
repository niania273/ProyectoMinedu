package com.minedu.project.maintenance_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;
import com.minedu.project.maintenance_management.service.SuministradorService;

@Controller
@RequestMapping("/requerimientos")
public class RequerimientoController {
	
	@Autowired
	private RequerimientoService reqService;
	
	@Autowired
	private SolicitudService solService;
	
	@Autowired
	private SuministradorService sumService;
	
	@GetMapping
	public String requerimientos(Model model) {
		model.addAttribute("lstRequerimientos", reqService.findAllRequerimientos());
		return "Requerimiento/Requerimientos";
	}
	
	@GetMapping("/generar")
	public String generarRequerimientos(Model model) {
		model.addAttribute("lstSolicitudes", solService.findAllSolicitudes());
		model.addAttribute("lstSuministradores", sumService.findAllSuministradores());	
		return "Requerimiento/GenerarRequerimiento";
	}
	
	@GetMapping("/actualizar")
	public String actualizarRequerimientos(@RequestParam("codRequerimiento") String codRequerimiento, Model model) {
	    
		Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
	    
	    model.addAttribute("requerimiento", requerimiento);
	    model.addAttribute("lstSuministradores", sumService.findAllSuministradores());
	    
	    return "Requerimiento/ActualizarRequerimiento";
	}
	
	@GetMapping("/detalles")
	public String detallesRequerimientos(@RequestParam("codRequerimiento") String codRequerimiento, Model model) {
	    
		Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
	    
	    model.addAttribute("requerimiento", requerimiento);
	    
	    return "Requerimiento/DetallesRequerimiento";
	}
	
}
