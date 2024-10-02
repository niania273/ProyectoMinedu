package com.minedu.project.maintenance_management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;

@Service
public class SolicitudService {
	
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	public List<Solicitud> findAllSolicitudes(){
		return solicitudRepository.findAll();
	}
	
	public Optional<Solicitud> findSolicitudById(String id){
		return solicitudRepository.findById(id);
	}
	
	public Solicitud saveSolicitud(Solicitud solicitud) {
		return solicitudRepository.save(solicitud);
	}
	
	public void deleteSolicitud (String id) {
		solicitudRepository.deleteById(id);
	}
}
