package com.minedu.project.maintenance_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Equipo;
import com.minedu.project.maintenance_management.repository.EquipoRepository;

@Service
public class EquipoService {
	
	@Autowired
    private EquipoRepository equipoRepository;
	
	public List<Equipo> findAllSubjects() {
        return equipoRepository.findAll();
    }

    public Equipo findEquipoById(String id) {
    	return equipoRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Equipo no encontrado:" + id));
    }
    
    public Equipo saveEquipo(Equipo equipo) {
    	return equipoRepository.save(equipo);
    }
    
    public void deleteEquipoById(String id) {
    	Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Solicitud no encontrada: " + id));
		
		equipoRepository.delete(equipo);
    }

    public String generateNuevoCodigo() {
		String ultimoCodigo = equipoRepository.findUltimoCodigo();
		
		if(ultimoCodigo == null || ultimoCodigo.isEmpty()) {
			return "EQ100";
		}
		
		String numero = ultimoCodigo.substring(2);
		int nuevo = Integer.parseInt(numero) +1;
		
		return "EQ" + nuevo;
	}
}
