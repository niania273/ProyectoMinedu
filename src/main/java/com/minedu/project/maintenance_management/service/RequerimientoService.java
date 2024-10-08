package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;

import java.util.*;

@Service
public class RequerimientoService {
	
	@Autowired
	private RequerimientoRepository requerimientoRepository;
	
	public List<Requerimiento> findAllRequerimientos() {
		return requerimientoRepository.findAll();
	}
	
	public Optional<Requerimiento> findRequerimientoById(String id) {
		return requerimientoRepository.findById(id);
	}
	
	public Requerimiento saveRequerimiento(Requerimiento requerimiento) {
		return requerimientoRepository.save(requerimiento);
	}
	
	public void deleteRequerimiento(String id) {
		requerimientoRepository.deleteById(id);
	}
}
