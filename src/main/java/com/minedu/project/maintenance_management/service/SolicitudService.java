package com.minedu.project.maintenance_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Solicitante;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.repository.SolicitanteRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;

@Service
public class SolicitudService {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public List<Solicitud> findAllSolicitudes(){
		return solicitudRepository.findAll();
	}
	
	public Solicitud findSolicitudById(String id) {
		return solicitudRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Solicitud no encontrada:" + id));
	}
	
	public SolicitudDTO findSolicitudDTOById(String id){
		
		Solicitud solicitud = solicitudRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Solicitud no encontrada:" + id));
		
		SolicitudDTO solicitudDTO = new SolicitudDTO();
		solicitudDTO.setDesSol(solicitud.getDesSol());
		solicitudDTO.setCatSol(solicitud.getCatSol());
		solicitudDTO.setNivPri(solicitud.getNivPri());
		solicitudDTO.setEstSol(solicitud.getEstSol());
		
		Solicitante solicitante = solicitud.getSolicitante();
		solicitudDTO.setCodSoli(solicitante.getCodSoli());
		solicitudDTO.setDniSoli(solicitante.getDniSoli());
		solicitudDTO.setNomSoli(solicitante.getNomSoli());
		solicitudDTO.setApeSoli(solicitante.getApeSoli());
		solicitudDTO.setEmaSoli(solicitante.getEmaSoli());
		solicitudDTO.setTelSoli(solicitante.getTelSoli());
		
		return solicitudDTO;
	}
	
	public Solicitud saveSolicitud(SolicitudDTO solicitudDTO) {
		
		Solicitante solicitante = new Solicitante();
		solicitante.setCodSoli(solicitudDTO.getCodSoli());
		solicitante.setDniSoli(solicitudDTO.getDniSoli());
		solicitante.setNomSoli(solicitudDTO.getNomSoli());
		solicitante.setApeSoli(solicitudDTO.getApeSoli());
		solicitante.setEmaSoli(solicitudDTO.getEmaSoli());
		solicitante.setTelSoli(solicitudDTO.getTelSoli());
		
		Solicitante savedSolicitante = solicitanteRepository.save(solicitante);
		
		Solicitud solicitud = new Solicitud();
		solicitud.setCodSol(solicitudDTO.getCodSol());
		solicitud.setDesSol(solicitudDTO.getDesSol());
		solicitud.setCatSol(solicitudDTO.getCatSol());
		solicitud.setNivPri(solicitudDTO.getNivPri());
		solicitud.setEstSol(solicitudDTO.getEstSol());
		
		solicitud.setSolicitante(savedSolicitante);
		
		return solicitudRepository.save(solicitud);
	}
	
	public void deleteSolicitudbyId (String id) {
		
		Solicitud solicitud = solicitudRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada: " + id));
		
		solicitudRepository.delete(solicitud);
	}
	
	public String generateNuevoCodigo() {
		String ultimoCodigo = solicitudRepository.findUltimoCodigo();
		
		if(ultimoCodigo == null || ultimoCodigo.isEmpty()) {
			return "ST100";
		}
		
		String numero = ultimoCodigo.substring(2);
		int nuevo = Integer.parseInt(numero) +1;
		
		return "ST" + nuevo;
	}
}
