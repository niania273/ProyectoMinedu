package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
			return suministradorRepository.findById(id).orElseThrow(()-> 
			new NoSuchElementException("No se encontró el Suministrador con el siguente ID " + id));
	}
	
	/* Agregar o Actualizar Suministrador */
	public Suministrador saveSuministrador(Suministrador newSuministrador) {
			try {
				newSuministrador.setCodSum(generateNewCodigo());
				return suministradorRepository.save(newSuministrador);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			
	}
	
	public String generateNewCodigo() {
		String ultimoCodigo = suministradorRepository.findUltimoCodigo();
		
		if(ultimoCodigo == null || ultimoCodigo.isEmpty()) {
			return "SU100";
		}
		
		String ultimoNumero = ultimoCodigo.substring(2);
		int nuevoNumero = Integer.parseInt(ultimoNumero) + 1;
		
		return "SU" + nuevoNumero;
	}
	
	
	/* Eliminar Suministrador */
	public void deleteSuministrador(String id) {
	    System.out.println("Intentando eliminar el suministrador con ID: " + id);
	    
	    if (suministradorRepository.existsById(id)) {
	        suministradorRepository.deleteById(id);
	        System.out.println("Suministrador con ID " + id + " eliminado de la base de datos.");
	    } else {
	        System.out.println("No se encontró el Suministrador para eliminar con ID: " + id);
	        throw new NoSuchElementException("No se encontró el Suministrador para eliminar con el siguiente ID: " + id);
	    }
	}

	public boolean existsById(String codSuministrador) {
		// TODO Auto-generated method stub
		 return suministradorRepository.existsById(codSuministrador);
	}


	

}
