package com.minedu.project.maintenance_management.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.service.ReporteService;
import com.minedu.project.maintenance_management.service.SolicitudEquipoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService solicitudService;
	
	@Autowired
	private SolicitudEquipoService solicitudEquipoService;
	
	@Autowired
	private ReporteService reporteService;
	
	@GetMapping
	public String getSolicitudes(Model model) {
		
		model.addAttribute("solicitudes", solicitudService.findAllSolicitudes());

		return "Solicitudes/Solicitudes";
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
	
	@PreAuthorize("hasAuthority('USAU')")
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
	
	@GetMapping("/exportar/{formato}")
	public ResponseEntity<byte[]> exportarSolicitud(@PathVariable String formato) throws JRException, IOException, SQLException {

	    byte[] reporte = reporteService.exportarSolicitud(formato);

	    HttpHeaders headers = new HttpHeaders();
	    String extension = formato.equals("excel") ? "xlsx" : 
				           formato.equals("csv") ? "csv" : 
				           formato.equals("doc") ? "docx" : 
				           formato;
	    headers.add("Content-Disposition", "attachment; filename=reporte_solicitudes." + extension);

	    return new ResponseEntity<>(reporte, headers, HttpStatus.OK);
	}

}