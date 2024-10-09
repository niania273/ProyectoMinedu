package com.minedu.project.maintenance_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.service.SolicitudEquipoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private SolicitudEquipoService solicitudEquipoService;
	
	
	@GetMapping
	public String getSolicitudes(Model model) {
		
		model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());

		return "Solicitudes/Solicitudes";
	}
	
	@GetMapping("/filtrar")
	public String filtrarSolicitudes(@RequestParam("codSol") String codSol, Model model) {
		if (codSol.isEmpty()) {
	        model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());
	    } else {
	        List<Solicitud> solicitudes = new ArrayList<>();
	        Solicitud solicitud = solicitudService.findSolicitudById(codSol);
	        if (solicitud != null) {
	            solicitudes.add(solicitud);
	        }
	        model.addAttribute("solicitudes", solicitudes);
	    }
	    return "Solicitudes/Solicitudes :: solicitudesTable";
	}
	
	@GetMapping("/ver/{id}")
	public String getSolicitudById(@PathVariable("id") String codSol, Model model) {
		
		try {
			SolicitudDTO solicitudDTO = solicitudService.findSolicitudDTOById(codSol);
			solicitudDTO.setCodSol(codSol);
			List<SolicitudEquipo> equipos = solicitudEquipoService.findSolicitudEquipoById(codSol);
			
			solicitudDTO.setEquipos(equipos);
			
			model.addAttribute("solicitudDTO", solicitudDTO);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes";
		}
		return "Solicitudes/VerSolicitud";
	}
	
	@GetMapping("/editar/{id}")
	public String updateSolicitud(@PathVariable("id") String codSol, Model model) {
		
		try {
			SolicitudDTO solicitudDTO = solicitudService.findSolicitudDTOById(codSol);
			solicitudDTO.setCodSol(codSol);
			List<SolicitudEquipo> equipos = solicitudEquipoService.findSolicitudEquipoById(codSol);
			
			solicitudDTO.setEquipos(equipos);
			
			model.addAttribute("solicitudDTO", solicitudDTO);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes";
		}
		return "Solicitudes/EditarSolicitud";
	}

	@PostMapping("/editar/{id}")
	public String updateSolicitud(@PathVariable("id") String codSol, 
            						Model model, 
            						@ModelAttribute SolicitudDTO solicitudDTO) {
		
		try {
			solicitudDTO.setCodSol(codSol);
			System.out.println(solicitudDTO.getCodSoli());
			solicitudService.updateSolicitud(solicitudDTO);
			System.out.println("Llegue aquí 3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes/editar/" + codSol;
		}
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/eliminar/{id}")
	public String deleteSolicitud(@PathVariable("id") String codSol) {
		try {
			solicitudService.deleteSolicitud(codSol);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/solicitudes";
	}
}
