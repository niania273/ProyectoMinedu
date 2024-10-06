package com.minedu.project.maintenance_management.controller;

/*import java.util.List;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minedu.project.maintenance_management.model.SolicitudDTO;
/*import com.minedu.project.maintenance_management.model.Solicitud;*/
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

	/*
    @GetMapping("/{id}")
    public Optional<Solicitud> getSolicitudById(@PathVariable String id) {
        return service.findSolicitudById(id);
    }
  
    @PostMapping
    public Solicitud createSolicitud(@RequestBody Solicitud solicitud) {
        return solicitudService.saveSolicitud(solicitud);
    }

    @PutMapping("/{id}")
    public Solicitud updateSolicitud(@PathVariable String id, @RequestBody Solicitud solicitudDetails) {
        Solicitud solicitud = solicitudService.findSolicitudById(id).orElseThrow(() -> new RuntimeException("¡Solicitud no encontrada!"));

        solicitud.setNivCla(solicitudDetails.getNivCla());
        solicitud.setEstSol(solicitudDetails.getEstSol());

        return solicitudService.saveSolicitud(solicitud);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable String id) {
        solicitudService.deleteSolicitud(id);
    }*/
}
