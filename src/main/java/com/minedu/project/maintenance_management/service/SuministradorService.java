package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.minedu.project.maintenance_management.repository.SolicitudRepository;
import com.minedu.project.maintenance_management.repository.SuministradorRepository;
import com.minedu.project.maintenance_management.model.Suministrador;

@Service
public class SuministradorService {

	@Autowired
	private SuministradorRepository suministradorRepository;
	
	/*Listar Todos los suministradores*/
	public List<Suministrador> findAllSuministradores(){
		return suministradorRepository.findAll();
	}
	
	/* Buscar solicitud por ID*/
	public Suministrador findSuministradorById(String id) {
			return suministradorRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontró el Suministrador con el siguente ID " + id));
	}
	
	/* Agregar o Actualizar Suministrador */
	public Suministrador saveSuministradorById(Suministrador suministrador) {
			return suministradorRepository.save(suministrador);
	}
	
	/* Eliminar Suministrador */
	public void deleteSuministrador (String id) {
		if(suministradorRepository.existsById(id)) {
			suministradorRepository.deleteById(id);
		}
		else {
			throw new NoSuchElementException("No se encontró el Suministrador para Eliminar con el Siguente ID: " + id);
		}
	}
}
