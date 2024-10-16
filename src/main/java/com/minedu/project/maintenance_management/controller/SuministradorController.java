package com.minedu.project.maintenance_management.controller;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	@PreAuthorize("hasAuthority('LOG')")
	@GetMapping ("/registrar")
	public String showRegistrarSuministrador(Model model) {
		model.addAttribute("suministrador", new Suministrador());
		return "Suministrador/RegistrarSuministrador";
	}
	
	@PreAuthorize("hasAuthority('LOG')")
	@GetMapping("/editar")
	public String showEditarSuministrador(@RequestParam("codSuministrador") String ID, Model model) {
	    Suministrador suministrador = service.findSuministradorById(ID);
	    model.addAttribute("suministrador", suministrador); // Asegúrate de pasar el objeto
	    return "Suministrador/EditarSuministrador"; // Carga la vista de edición
	}

	
	@PostMapping("/actualizar")
	public String actualizarSuministrador(@ModelAttribute("suministrador") Suministrador suministrador, Model model) {
	    try {
	        service.saveSuministradorById(suministrador);
	        model.addAttribute("mensaje", "Datos actualizados correctamente");
	        return "redirect:/suministradores"; // Redirigir a la lista de suministradores
	    } catch (NoSuchElementException e) {
	        model.addAttribute("mensaje", "Error: No se encontró el suministrador para actualizar.");
	        e.printStackTrace(); // Imprimir el error en la consola del servidor
	    } catch (Exception e) {
	        model.addAttribute("mensaje", "Error al actualizar los datos: " + e.getMessage());
	        e.printStackTrace(); // Imprimir el error en la consola del servidor
	    }
	    return "Suministrador/EditarSuministrador"; // Regresar a la página de edición si hay un error
	}


	
	/*
	@PreAuthorize("hasAuthority('LOG')")
	@DeleteMapping("/eliminar")
	public String eliminarSuministrador(@ModelAttribute("codSuministrador")String ID, Model model) {
		Suministrador suministrador = service.findSuministradorById(ID);
		service.deleteSuministrador(suministrador.getCodSum());
		model.addAttribute("mensaje", "Suministrador Eliminado");
		
		return "/suministradores";
	}
	*/
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<Void> eliminarSuministrador(@RequestParam String codSuministrador) {
	    try {
	        Suministrador suministrador = service.findSuministradorById(codSuministrador);
	        service.deleteSuministrador(suministrador.getCodSum());
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } catch (NoSuchElementException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
	    }
	}
}
