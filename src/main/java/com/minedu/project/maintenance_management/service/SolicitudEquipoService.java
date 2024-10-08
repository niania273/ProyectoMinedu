package com.minedu.project.maintenance_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.model.SolicitudEquipoPK;
import com.minedu.project.maintenance_management.repository.SolicitudEquipoRepository;

@Service
public class SolicitudEquipoService {
	
	@Autowired
	private SolicitudEquipoRepository solicitudEquipoRepository;
	
	public void saveSolicitudEquipo(SolicitudEquipo solicitudEquipo) {
		solicitudEquipoRepository.save(solicitudEquipo);
	}
	
	public List<SolicitudEquipo> findAllSolicitudesEquipos(){
		return solicitudEquipoRepository.findAll();
	}
	
	public void deleteSolicitudEquipoBySolicitudId(String solicitudId, String equipoId) {
		SolicitudEquipoPK solicitudEquipoId = new SolicitudEquipoPK(solicitudId, equipoId);
		
		SolicitudEquipo solicitudEquipo = solicitudEquipoRepository.findById(solicitudEquipoId).orElseThrow(() -> new IllegalArgumentException("SolicitudEquipo no encontrada con los IDs: " + solicitudId + " y " + equipoId));
		
		solicitudEquipoRepository.delete(solicitudEquipo);		
	}
}
