package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Solicitante;
import com.minedu.project.maintenance_management.repository.SolicitanteRepository;

@Service
public class SolicitanteService {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	public Solicitante findById(String id) {
		return solicitanteRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Solicitante no encontrado:" + id));
	}
	
	public String generateNuevoCodigo() {
		String ultimoCodigo = solicitanteRepository.findUltimoCodigo();
		
		if(ultimoCodigo == null || ultimoCodigo.isEmpty()) {
			return "SL100";
		}
		
		String numero = ultimoCodigo.substring(2);
		int nuevo = Integer.parseInt(numero) +1;
		
		return "SL" + nuevo;
	}
}
