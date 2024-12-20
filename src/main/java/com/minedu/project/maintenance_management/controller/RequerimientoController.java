package com.minedu.project.maintenance_management.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.service.ReporteService;
import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;
import com.minedu.project.maintenance_management.service.SuministradorService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/requerimientos")
public class RequerimientoController {
	
	@Autowired
	private RequerimientoService reqService;
	
	@Autowired
	private SolicitudService solService;
	
	@Autowired
	private SuministradorService sumService;
	
	@Autowired
	private ReporteService reporteService;
	
	@GetMapping
	public String requerimientos(Model model) {
		model.addAttribute("lstRequerimientos", reqService.findAllRequerimientos());
		return "Requerimiento/Requerimientos";
	}
	
	@PreAuthorize("hasAuthority('USAU')")
	@GetMapping("/generar")
	public String generarRequerimientos(Model model) {
		
		List<Solicitud> solicitudesPendientes = solService.findAllSolicitudes().stream()
		        .filter(solicitud -> "Pendiente".equals(solicitud.getEstSol()))
		        .collect(Collectors.toList());
		
		model.addAttribute("lstSolicitudes", solicitudesPendientes);
		model.addAttribute("lstSuministradores", sumService.findAllSuministradores());	
		model.addAttribute("requerimiento", new Requerimiento());
		
		LocalDate fechaActual = LocalDate.now();
		String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ISO_LOCAL_DATE);
		model.addAttribute("fechaActual", fechaActualFormateada);
		
		return "Requerimiento/GenerarRequerimiento";
	}
	
	@PostMapping("/generar")
	public String generarRequerimientos(Model model, @ModelAttribute Requerimiento newRequerimiento) {
		try {

			reqService.saveRequerimiento(newRequerimiento); 
			
			return "redirect:/requerimientos";
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			
			return "redirect:/requerimientos/generar";
		}
		
	}
	
	@PreAuthorize("hasAuthority('USAU')")
	@GetMapping("/actualizar/{codRequerimiento}")
	public String actualizarRequerimientos(@PathVariable String codRequerimiento, Model model) {
	    
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
			
			return "redirect:/requerimientos";
		}
		
	}
	
	@PostMapping("/actualizar/{codRequerimiento}")
	public String actualizarRequerimiento(
			@PathVariable String codRequerimiento,
			@ModelAttribute Requerimiento newRequerimiento, 
			Model model) {
		
	    try {
	    	String codSum = newRequerimiento.getSuministrador().getCodSum();
	        
	        Suministrador suministrador = sumService.findSuministradorById(codSum);
	        
	        newRequerimiento.setSuministrador(suministrador);
	        newRequerimiento.setCodReq(codRequerimiento);
	        
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
	public String detallesRequerimientos(@PathVariable String codRequerimiento, Model model) {
		try	{
			
			Requerimiento requerimiento = reqService.findRequerimientoById(codRequerimiento);
			model.addAttribute("requerimiento", requerimiento);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());	    
			return "redirect:/requerimientos";
		}
		return "Requerimiento/DetallesRequerimiento";
	}
	
	@PreAuthorize("hasAuthority('USAU')")
	@GetMapping("/eliminar/{codRequerimiento}")
	public String eliminarRequerimiento(@PathVariable String codRequerimiento, Model model) {
		try	{
			reqService.deleteRequerimiento(codRequerimiento);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/requerimientos";
	}
	
	@GetMapping("/exportar/{formato}")
	public ResponseEntity<byte[]> exportarSolicitud(@PathVariable String formato) throws JRException, IOException, SQLException {

	    byte[] reporte = reporteService.exportarRequerimiento(formato);

	    HttpHeaders headers = new HttpHeaders();
	    String extension = formato.equals("excel") ? "xlsx" : 
				           formato.equals("csv") ? "csv" : 
				           formato.equals("doc") ? "docx" : 
				           formato;
	    headers.add("Content-Disposition", "attachment; filename=reporte_requerimientos." + extension);

	    return new ResponseEntity<>(reporte, headers, HttpStatus.OK);
	}
	
}
