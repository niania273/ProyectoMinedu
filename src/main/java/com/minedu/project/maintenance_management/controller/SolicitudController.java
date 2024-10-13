package com.minedu.project.maintenance_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.Equipo;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.service.EquipoService;
import com.minedu.project.maintenance_management.service.SolicitanteService;
import com.minedu.project.maintenance_management.service.SolicitudEquipoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

import jakarta.validation.Valid;

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
	public String getSolicitudes(Model model) {
		
		model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());

		return "Solicitudes/Solicitudes";
	}
	
	@GetMapping("/crear")
	public String createSolicitud(Model model) {
	/*	String codigoSolicitud = solicitudService.generateNuevoCodigo();
		String codigoSolicitante = solicitanteService.generateNuevoCodigo();
		
		SolicitudDTO solicitudDTO = new SolicitudDTO();
		solicitudDTO.setEquipos(new ArrayList<>());
	    solicitudDTO.setListaEquipos(new ArrayList<>());
		solicitudDTO.setCodSol(codigoSolicitud);
		solicitudDTO.setCodSoli(codigoSolicitante);
		
		List<Equipo> listEquipo = new ArrayList<Equipo>();
		
		for (int i = 0; i < 5; i++) {
			Equipo equipo = new Equipo();
			String codigo = equipoService.generateNuevoCodigo();
			equipo.setCodEqu(codigo);
			listEquipo.add(equipo);
		}
		//solicitudDTO.setListaEquipos(listEquipo);
		
		model.addAttribute("solicitudDTO", solicitudDTO);*/
		return "Solicitudes/GenerarSolicitud";
	}
	
	@PostMapping("/crear")
	public String createSolicitud(@Valid @ModelAttribute SolicitudDTO solicitudDTO) {
		
		/*List<SolicitudEquipo> solicitudEquipos = new ArrayList<>();
		
		for (int i = 0; i < solicitudDTO.getListaEquipos().size(); i++) {
			Equipo equipo = solicitudDTO.getListaEquipos().get(i);
			Byte cantidad = solicitudDTO.getCanEqu().get(i);
			
			if (cantidad > 0) {
				SolicitudEquipo solicitudEquipo = new SolicitudEquipo();
				solicitudEquipo.setEquipo(equipo);
				solicitudEquipo.setCanEqu(cantidad);
				solicitudEquipos.add(solicitudEquipo);
			}
		}
		
		solicitudDTO.setEquipos(solicitudEquipos);
		
		Solicitud solicitud = solicitudService.saveSolicitud(solicitudDTO);
		
		for (SolicitudEquipo solicitudEquipo : solicitudEquipos) {
            solicitudEquipo.setSolicitud(solicitud);
            solicitudEquipoService.saveSolicitudEquipo(solicitudEquipo);
        }*/
		
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/ver/{codSol}")
	public String getSolicitudById(@PathVariable("codSol") String codSol, Model model) {
		
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
	
	@GetMapping("/editar/{codSol}")
	public String updateSolicitud(@PathVariable("codSol") String codSol, Model model) {
		
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

	@PostMapping("/editar/{codSol}")
	public String updateSolicitud(@PathVariable("codSol") String codSol, 
			Model model, 
			@ModelAttribute SolicitudDTO solicitudDTO) {
		
		try {
			solicitudService.updateSolicitud(solicitudDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/solicitudes/editar/";
		}
		return "redirect:/solicitudes";
	}
	
	@GetMapping("/eliminar/{codSol}")
	public String deleteSolicitud(@PathVariable("codSol") String codSol) {
		try {
			solicitudService.deleteSolicitud(codSol);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:/solicitudes";
	}
}
