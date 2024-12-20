package com.minedu.project.maintenance_management.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minedu.project.maintenance_management.model.Equipo;
import com.minedu.project.maintenance_management.model.Solicitante;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.SolicitudDTO;
import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.repository.EquipoRepository;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;
import com.minedu.project.maintenance_management.repository.SolicitanteRepository;
import com.minedu.project.maintenance_management.repository.SolicitudEquipoRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SolicitudService {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	@Autowired
	private SolicitudEquipoRepository solicitudEquipoRepository;
	
	@Autowired
	private RequerimientoRepository requerimientoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private SolicitanteService solicitanteService;
	
	public List<Solicitud> findAllSolicitudes(){
		return solicitudRepository.findAll();
	}
	
	public Solicitud findSolicitudById(String codSol) {
		return solicitudRepository.findById(codSol).orElseThrow( () -> new IllegalArgumentException("Solicitud no encontrada:" + codSol));
	}
	
	public SolicitudDTO findSolicitudDTOById(String id){
		
		Solicitud solicitud = solicitudRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("SolicitudDTO no encontrada:" + id));
		
		SolicitudDTO solicitudDTO = new SolicitudDTO();
		solicitudDTO.setCodSol(solicitud.getCodSol());
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
	
	@Transactional
	public void updateSolicitud(SolicitudDTO solicitudDTO) {
		
		LocalDate fechaActual = LocalDate.now();
		
		Solicitante solicitante = solicitanteService.findById(solicitudDTO.getCodSoli());
		
		solicitante.setCodSoli(solicitudDTO.getCodSoli());
		solicitante.setDniSoli(solicitudDTO.getDniSoli());
		solicitante.setNomSoli(solicitudDTO.getNomSoli());
		solicitante.setApeSoli(solicitudDTO.getApeSoli());
		solicitante.setEmaSoli(solicitudDTO.getEmaSoli());
		solicitante.setTelSoli(solicitudDTO.getTelSoli());
		
		Solicitante savedSolicitante = solicitanteRepository.save(solicitante);
		Solicitud solicitud = findSolicitudById(solicitudDTO.getCodSol());
		solicitud.setDesSol(solicitudDTO.getDesSol());
		solicitud.setCatSol(solicitudDTO.getCatSol());
		solicitud.setNivPri(solicitudDTO.getNivPri());
		solicitud.setEstSol(solicitudDTO.getEstSol());
		
		Date fechaAct = Date.valueOf(fechaActual);
	    solicitud.setFecAct(fechaAct);
	    
		solicitud.setSolicitante(savedSolicitante);
		
		solicitudRepository.save(solicitud);
		
		if (solicitudDTO.getEquipos() != null && !solicitudDTO.getEquipos().isEmpty()) {
	        for (SolicitudEquipo solEqu : solicitudDTO.getEquipos()) {
	            
	        	Equipo equipo = equipoRepository.findById(solEqu.getEquipo().getCodEqu()).orElseThrow(() -> new EntityNotFoundException("Equipo no encontrado"));
	        	equipo.setNomEqu(solEqu.getEquipo().getNomEqu());;
	        	solEqu.setCanEqu(solEqu.getCanEqu());        	
	        	
	        	solEqu.setSolicitud(solicitud);            
	        	solicitudEquipoRepository.save(solEqu);        	
	        	
	        }
	    } else {
	        System.out.println("No hay equipos asociados a esta solicitud.");
	    }
	}
	
	@Transactional
	public void deleteSolicitud(String codSol) {
		
		List<SolicitudEquipo> equiposAsociados = solicitudEquipoRepository.findBySolicitud_CodSol(codSol);
	    
	    for (SolicitudEquipo solEqu : equiposAsociados) {
	        equipoRepository.delete(solEqu.getEquipo());
	    }	
		
		solicitudEquipoRepository.deleteBySolicitud_CodSol(codSol);
		requerimientoRepository.deleteBySolicitud_CodSol(codSol);
		solicitudRepository.deleteById(codSol);
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
