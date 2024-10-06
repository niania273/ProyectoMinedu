package com.minedu.project.maintenance_management.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Solicitud> findSolicitudById(String id){
		return solicitudRepository.findById(id);
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
	
	public void deleteSolicitud (String id) {
		solicitudRepository.deleteById(id);
	}
	
	public List<Solicitud> findByKeyword(String keyword){
		return solicitudRepository.findByKeyword(keyword);
	}
}
