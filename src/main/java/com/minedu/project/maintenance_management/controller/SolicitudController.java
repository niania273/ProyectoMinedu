package com.minedu.project.maintenance_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.Equipo;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.service.EquipoService;
import com.minedu.project.maintenance_management.service.SolicitanteService;
import com.minedu.project.maintenance_management.service.SolicitudEquipoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private SolicitanteService solicitanteService;
	
	@Autowired
	private SolicitudEquipoService solicitudEquipoService;
	
	@Autowired
	private EquipoService equipoService;
	
	@GetMapping
	public String getSolicitudes(Model model, String keyword) {
		
		
		model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());

		return "Solicitudes/Solicitudes";
	}
	
	@GetMapping("/crear")
	public String createSolicitud(Model model) {
		String codigoSolicitud = solicitudService.generateNuevoCodigo();
		String codigoSolicitante = solicitanteService.generateNuevoCodigo();
		String codigoEquipo = equipoService.generateNuevoCodigo();
		
		SolicitudDTO solicitudDTO = new SolicitudDTO();
		solicitudDTO.setCodSol(codigoSolicitud);
		solicitudDTO.setCodSoli(codigoSolicitante);
		
		Equipo equipo = new Equipo();
		equipo.setCodEqu(codigoEquipo);
		
		solicitudDTO.setEquipo(equipo);
		
		model.addAttribute("solicitudDTO", solicitudDTO);
		return "Solicitudes/CrearSolicitud";
	}
	
	@PostMapping("/crear")
	public String createSolicitud(@ModelAttribute SolicitudDTO solicitudDTO) {
		
			SolicitudEquipo solicitudEquipo = new SolicitudEquipo();
			
			Solicitud solicitud = solicitudService.saveSolicitud(solicitudDTO);
			solicitudEquipo.setSolicitud(solicitud);
			
			Equipo equipo = new Equipo();
			equipo.setCodEqu(solicitudDTO.getEquipo().getCodEqu());
			equipo.setNomEqu(solicitudDTO.getEquipo().getNomEqu());
			
			equipoService.saveEquipo(equipo);
			solicitudEquipo.setEquipo(equipo);			
			
			Byte canEqu = solicitudDTO.getCanEqu();			
			solicitudEquipo.setCanEqu(canEqu);
			
			solicitudEquipoService.saveSolicitudEquipo(solicitudEquipo);
		
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/editar/{id}")
	public String getSolicitudById(@PathVariable String id, Model model) {
		
		try {
			SolicitudDTO solicitudDTO = solicitudService.findSolicitudDTOById(id);
			solicitudDTO.setCodSol(id);
			model.addAttribute("solicitudDTO", solicitudDTO);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes";
		}
		return "Solicitudes/EditarSolicitud";
	}

	@PostMapping("/editar/{id}")
	public String updateSolicitud(Model model, @PathVariable String id, @ModelAttribute SolicitudDTO solicitudDTO) {
		
		try {
			solicitudDTO.setCodSol(id);
			solicitudService.saveSolicitud(solicitudDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/eliminar/{solicitudId}/{equipoId}")
	public String deleteSolicitud(@PathVariable String solicitudId, @PathVariable String equipoId) {
		try {
			solicitudEquipoService.deleteSolicitudEquipoBySolicitudId(solicitudId, equipoId);
			solicitudService.deleteSolicitudbyId(solicitudId);
			equipoService.deleteEquipoById(equipoId);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/solicitudes";
	}
}
