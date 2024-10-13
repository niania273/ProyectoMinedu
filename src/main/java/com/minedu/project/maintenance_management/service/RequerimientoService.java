package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;

import jakarta.transaction.Transactional;

import java.util.*;

@Service
public class RequerimientoService {
	
	SuministradorService sumService;
	
	@Autowired
	private RequerimientoRepository requerimientoRepository;
	
	public List<Requerimiento> findAllRequerimientos() {
		return requerimientoRepository.findAll();
	}
	
	public Requerimiento findRequerimientoById(String id) {
		
		return requerimientoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontró el Requerimiento con el siguente ID " + id));
		
	}
	
	public Requerimiento saveRequerimiento(Requerimiento requerimiento) {
		return requerimientoRepository.save(requerimiento);
	}
	
	public void deleteRequerimiento(String id) {
		requerimientoRepository.deleteById(id);
	}
	
	@Transactional
	public Requerimiento updateRequerimiento(Requerimiento requerimiento) {
		
        Optional<Requerimiento> existingRequerimientoOpt = requerimientoRepository.findById(requerimiento.getCodReq());
        System.out.println("SERVICE");
        
        if (!existingRequerimientoOpt.isPresent()) {
            throw new RuntimeException("Requerimiento no encontrado con el código: " + requerimiento.getCodReq());
        }
        
        Requerimiento existingRequerimiento = existingRequerimientoOpt.get();
        
        existingRequerimiento.setTitReq(requerimiento.getTitReq());
        existingRequerimiento.setDesReq(requerimiento.getDesReq());
        existingRequerimiento.setPlaEjeReq(requerimiento.getPlaEjeReq());
        existingRequerimiento.setPreReq(requerimiento.getPreReq());
        existingRequerimiento.setFecLim(requerimiento.getFecLim());
        existingRequerimiento.setEstReq(requerimiento.getEstReq());
        
        
        existingRequerimiento.setSuministrador(requerimiento.getSuministrador());
        System.out.println(existingRequerimiento.getSolicitud().getCodSol());
        System.out.println("Updating requerimiento: " + requerimiento);
        System.out.println("Existing requerimiento before update: " + existingRequerimiento);

        
        return requerimientoRepository.save(existingRequerimiento);
		
	}
}
