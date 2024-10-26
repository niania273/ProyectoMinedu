package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.*;



@Service
public class RequerimientoService {
	
	@Autowired
	private SolicitudRepository solRepo;
	
	@Autowired
	private RequerimientoRepository requerimientoRepository;
	
	public List<Requerimiento> findAllRequerimientos() {
		return requerimientoRepository.findAll();
	}
	
	public Requerimiento findRequerimientoById(String id) {
		
		return requerimientoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No se encontró el Requerimiento con el siguente ID " + id));
		
	}
	
	public String generateNewCodigo() {
		String ultimoCodigo = requerimientoRepository.findUltimoCodigo();
		
		if(ultimoCodigo == null || ultimoCodigo.isEmpty()) {
			return "RQ100";
		}
		
		String ultimoNumero = ultimoCodigo.substring(2);
		int nuevoNumero = Integer.parseInt(ultimoNumero) + 1;
		
		return "RQ" + nuevoNumero;
	}
	
	public Requerimiento saveRequerimiento(Requerimiento newRequerimiento) {
		try {
			
			newRequerimiento.setCodReq(generateNewCodigo());
			newRequerimiento.setEstReq("Activo");
			newRequerimiento.setFecCre(LocalDate.now());
			newRequerimiento.setFecAct(LocalDate.now());
			Solicitud solAsociada = solRepo.findById(newRequerimiento.getSolicitud().getCodSol()).get();
			
			solAsociada.setEstSol("Programada");
			
			solRepo.save(solAsociada);
			
			return requerimientoRepository.save(newRequerimiento);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return null;
		}
		
	}
	
	public void deleteRequerimiento(String id) {
		Solicitud solAsociada = solRepo.findById(requerimientoRepository.findById(id).get().getSolicitud().getCodSol()).get();		
		solAsociada.setEstSol("Pendiente");
		requerimientoRepository.deleteById(id);
	}
	
	@Transactional
	public Requerimiento updateRequerimiento(Requerimiento requerimiento) {
		
        Optional<Requerimiento> existingRequerimientoOpt = requerimientoRepository.findById(requerimiento.getCodReq());
        
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

        
        return requerimientoRepository.save(existingRequerimiento);
		
	}
}
