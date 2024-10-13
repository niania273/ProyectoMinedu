package com.minedu.project.maintenance_management.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Suministrador;
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
	
	@GetMapping("/actualizar/{codRequerimiento}")
	public String actualizarRequerimientos(@PathVariable("codRequerimiento") String codRequerimiento, Model model) {
	    
		try	{
			Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
			
			model.addAttribute("requerimiento", requerimiento);
			model.addAttribute("lstSuministradores", sumService.findAllSuministradores());
			
			LocalDate fechaActual = LocalDate.now();
			String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ISO_LOCAL_DATE);
			model.addAttribute("fechaActual", fechaActualFormateada);
			
			return "Requerimiento/ActualizarRequerimiento";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/requerimientos";
	}
	
	@PostMapping("/actualizar/{codRequerimiento}")
	public String actualizarRequerimiento(
			@PathVariable("codRequerimiento") String codRequerimiento,
			@ModelAttribute Requerimiento newRequerimiento, 
			Model model) {
		
	    try {
	    	String codSum = newRequerimiento.getSuministrador().getCodSum();
	        
	    	
	        Suministrador suministrador = sumService.findSuministradorById(codSum);
	        newRequerimiento.setSuministrador(suministrador);
	        newRequerimiento.setCodReq(codRequerimiento);
	        System.out.println("CONTROLLER");
	        
	        reqService.updateRequerimiento(newRequerimiento);
	        
	        model.addAttribute("message", "Requerimiento actualizado exitosamente");
	        
	        return "redirect:/requerimientos"; 
	    } catch (Exception e) {
	    	System.out.println(e.getMessage());
	    	model.addAttribute("error", "Error al actualizar el requerimiento: " + e.getMessage());
	        return "redirect:/requerimientos/actualizar/{codRequerimiento}";
	    }
	}

	
	@GetMapping("/detalles/{codRequerimiento}")
	public String detallesRequerimientos(@PathVariable("codRequerimiento") String codRequerimiento, Model model) {
	    
		try	{
			
			Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
			model.addAttribute("requerimiento", requerimiento);
			return "Requerimiento/DetallesRequerimiento";
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    
		return "redirect:/requerimientos";
	}
	
	@GetMapping("/eliminar/{codRequerimiento}")
	public String eliminarRequerimiento(@PathVariable("codRequerimiento") String codRequerimiento, Model model) {
		try	{
			reqService.deleteRequerimiento(codRequerimiento);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/requerimientos";
	}
	
}
