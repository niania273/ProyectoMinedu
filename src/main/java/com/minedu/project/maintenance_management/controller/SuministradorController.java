package com.minedu.project.maintenance_management.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.service.ReporteService;
import com.minedu.project.maintenance_management.service.SuministradorService;

import net.sf.jasperreports.engine.JRException;


@Controller
@RequestMapping("/suministradores")
public class SuministradorController {
	
	@Autowired 
	private SuministradorService service;
	
	@Autowired
	private ReporteService repoService;
	
	@GetMapping
	public String listSuministradores(Model model) {
		model.addAttribute("lstSuministradores", service.findAllSuministradores());
		return "Suministrador/Suministradores";
	}
	
	@PreAuthorize("hasAuthority('LOG')")
	@GetMapping("/generar")
	public String showRegistrarSuministrador(Model model) {
		model.addAttribute("suministrador", new Suministrador());
	    return "Suministrador/registrarsuministrador";
	}

	@PostMapping("/guardar")
	public String registrarSuministrador(Model model, @ModelAttribute Suministrador newSuministrador) {
	    try {
	        
	    	service.saveSuministrador(newSuministrador);
	    		        
	        return "redirect:/suministradores";
	        
	    } catch (Exception e) {
	    	
	        model.addAttribute("mensaje", "Error al registrar el suministrador: " + e.getMessage());
	        return "Suministrador/RegistrarSuministrador"; 
	    }
	}
	
	@GetMapping("/detalles/{codSuministrador}")
	public String detallesSuministrador(@PathVariable String codSuministrador, Model model) {
		
		try {
			System.out.println(codSuministrador);
			Suministrador suministrador = service.findSuministradorById(codSuministrador);
			model.addAttribute("suministrador", suministrador);
			return "Suministrador/DetallesSuministrador";
			
		} catch (Exception e) {
			return "redirect:/suministradores";
		}
	}


	
	@PreAuthorize("hasAuthority('LOG')")
	@GetMapping("/editar")
	public String showEditarSuministrador(@RequestParam("codSuministrador") String ID, Model model) {
	    Suministrador suministrador = service.findSuministradorById(ID);
	    model.addAttribute("suministrador", suministrador);
	    return "Suministrador/EditarSuministrador";
	}

	
	@PostMapping("/editar/{codSuministrador}")
	public String actualizarSuministrador(@PathVariable String codSuministrador, @ModelAttribute Suministrador suministrador, Model model) {
	    try {
	    	service.updateSuministrador(suministrador);
	        model.addAttribute("mensaje", "Datos actualizados correctamente");
	        return "redirect:/suministradores";
	    } catch (NoSuchElementException e) {
	        model.addAttribute("mensaje", "Error: No se encontró el suministrador para actualizar.");
	        e.printStackTrace();
	    } catch (Exception e) {
	        model.addAttribute("mensaje", "Error al actualizar los datos: " + e.getMessage());
	        e.printStackTrace();
	    }
	    return "Suministrador/EditarSuministrador";
	}	
	
	@PreAuthorize("hasAuthority('LOG')")
	@DeleteMapping("/eliminar")
	public ResponseEntity<Void> eliminarSuministrador(@RequestParam String codSuministrador) {
	    // Verificar que se recibe el parámetro
	    System.out.println("Solicitud de eliminación recibida para el codSuministrador: " + codSuministrador);
	    
	    try {
	        // Verificar si el suministrador existe
	        if (!service.existsById(codSuministrador)) {
	            System.out.println("Suministrador no encontrado con ID: " + codSuministrador);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
	        }

	        // Llamar al método de eliminación
	        service.deleteSuministrador(codSuministrador);
	        System.out.println("Suministrador eliminado exitosamente: " + codSuministrador);
	        return ResponseEntity.noContent().build(); // 204 No Content
	    } catch (NoSuchElementException e) {
	        System.out.println("Error: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404 Not Found
	    } catch (Exception e) {
	        System.out.println("Error al eliminar suministrador: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
	    }
	}
	
	@GetMapping("/exportar/{formato}")
	public ResponseEntity<byte[]> exportarSolicitud(@PathVariable String formato) throws JRException, IOException, SQLException {

	    byte[] reporte = repoService.exportarSuministrador(formato);

	    HttpHeaders headers = new HttpHeaders();
	    String extension = formato.equals("excel") ? "xlsx" : 
				           formato.equals("csv") ? "csv" : 
				           formato.equals("doc") ? "docx" : 
				           formato;
	    headers.add("Content-Disposition", "attachment; filename=reporte_suministradores." + extension);

	    return new ResponseEntity<>(reporte, headers, HttpStatus.OK);
	}
	
}
