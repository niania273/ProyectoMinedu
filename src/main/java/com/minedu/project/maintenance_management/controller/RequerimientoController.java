package com.minedu.project.maintenance_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
@RequestMapping("/requerimientos")
public class RequerimientoController {
	
	@Autowired
	private RequerimientoService reqService;
	
	@Autowired
	private SolicitudService solService;
	
	@GetMapping
	public String requerimientos(Model model) {
		model.addAttribute("lstRequerimientos", reqService.findAllRequerimientos());
		return "Requerimientos";
	}
	
	@GetMapping("/generar")
	public String generarRequerimientos(Model model) {
		model.addAttribute("lstSolicitudes", solService.findAllSolicitudes());
			return "GenerarRequerimiento";
	}
	
	@GetMapping("/actualizar")
	public String actualizarRequerimientos(@RequestParam("codRequerimiento") String codRequerimiento, Model model) {
	    
		Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
	    
	    if (requerimiento != null) {
	        model.addAttribute("requerimiento", requerimiento);
	    } else {
	        model.addAttribute("error", "Requerimiento no encontrado");
	        return "ErrorPage"; // o la página de error que desees
	    }
	    
	    return "ActualizarRequerimiento";
	}
	
	
}
