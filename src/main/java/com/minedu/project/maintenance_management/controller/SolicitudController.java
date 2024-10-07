package com.minedu.project.maintenance_management.controller;


/*import java.util.List;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@GetMapping
	public String getSolicitudes(Model model, String keyword) {
		
		if(keyword != null) {
			model.addAttribute("solicitudes", solicitudService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());
		}
		
		return "Solicitudes/Solicitudes";
	}
	
	@GetMapping("/crear")
	public String createSolicitud(Model model) {
		SolicitudDTO solicitudDTO = new SolicitudDTO();
		model.addAttribute("solicitudDTO", solicitudDTO);
		return "Solicitudes/CrearSolicitud";
	}
	
	@PostMapping("/crear")
	public String createSolicitud(@ModelAttribute SolicitudDTO solicitudDTO) {
		solicitudService.saveSolicitud(solicitudDTO);
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/editar/{id}")
	public String getSolicitudById(@PathVariable String id, Model model) {
		
		try {
			SolicitudDTO solicitudDTO = solicitudService.findSolicitudById(id);
			model.addAttribute("solicitudDTO", solicitudDTO);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes";
		}
		return "Solicitudes/EditarSolicitud";
	}

	@PostMapping("/editar")
	public String updateSolicitud(Model model, @RequestParam String id, @ModelAttribute SolicitudDTO solicitudDTO) {
		
		try {
			solicitudService.saveSolicitud(solicitudDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/eliminar/{id}")
	public String deleteSolicitud(@PathVariable String id) {
		try {
			solicitudService.deleteSolicitudbyId(id);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/solicitudes";
	}
}
