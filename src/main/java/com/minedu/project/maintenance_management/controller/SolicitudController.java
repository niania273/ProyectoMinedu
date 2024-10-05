package com.minedu.project.maintenance_management.controller;

/*import java.util.List;
import java.util.Optional;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*import com.minedu.project.maintenance_management.model.Solicitud;*/
import com.minedu.project.maintenance_management.service.SolicitudService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudController {
	
	@Autowired
	private SolicitudService service;
	
	@GetMapping
	public String listSolicitudes(Model model) {
		model.addAttribute("lstSolicitudes", service.findAllSolicitudes());
		return "Solicitudes";
	}
	/*

    @GetMapping("/{id}")
    public Optional<Solicitud> getSolicitudById(@PathVariable String id) {
        return solicitudService.findSolicitudById(id);
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
