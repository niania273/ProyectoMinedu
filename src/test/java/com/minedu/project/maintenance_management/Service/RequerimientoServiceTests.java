package com.minedu.project.maintenance_management.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;
import com.minedu.project.maintenance_management.repository.SuministradorRepository;
import com.minedu.project.maintenance_management.service.RequerimientoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class RequerimientoServiceTests {
	
	@Mock
	private SolicitudRepository solRepo;
	
	@Mock
	private SuministradorRepository sumRepo;
	
	@Mock
	private RequerimientoRepository reqRepository;
	
	private Requerimiento requerimiento;
	
	@InjectMocks
	private RequerimientoService reqService;
	
	@BeforeEach
	void setUp() {
		
		requerimiento = new Requerimiento();
		requerimiento.setCodReq("RQ999");
		requerimiento.setSolicitud(new Solicitud());
		requerimiento.getSolicitud().setCodSol("ST101");
		requerimiento.setSuministrador(new Suministrador());
		requerimiento.setTitReq("Du isst einen Brot");
		requerimiento.setEstReq("Generado");
		requerimiento.setDesReq("Einen Apfel");
		requerimiento.setPlaEjeReq("Nein");
		requerimiento.setPreReq(30.50);
		requerimiento.setFecLim(LocalDate.now());
		requerimiento.setFecCre(LocalDate.now());
		requerimiento.setFecAct(LocalDate.now());
	}
	
	@Test
	void testFindAllRequerimientos() {
		
		when(reqRepository.findAll()).thenReturn(Arrays.asList(requerimiento));
		assertNotNull(reqService.findAllRequerimientos());
	}
	
	@Test
	void testFindRequerimientoById() {
		when(reqRepository.findById(requerimiento.getCodReq())).thenReturn(Optional.of(requerimiento));
		assertEquals(requerimiento, reqService.findRequerimientoById(requerimiento.getCodReq()));
	}
	
	@Test
	void testSaveRequerimiento() {
		
		when(solRepo.findById(requerimiento.getSolicitud().getCodSol())).thenReturn(Optional.of(requerimiento.getSolicitud()));
		
		when(reqRepository.save(requerimiento)).thenReturn(requerimiento);
		assertNotNull(reqService.saveRequerimiento(requerimiento));
	}
	
	@Test
	void testDeleteRequerimiento() {
		
		when(reqRepository.findById(requerimiento.getCodReq())).thenReturn(Optional.of(requerimiento));
		when(solRepo.findById(requerimiento.getSolicitud().getCodSol())).thenReturn(Optional.of(requerimiento.getSolicitud()));		
		
		reqService.deleteRequerimiento(requerimiento.getCodReq());
		verify(reqRepository, times(1)).deleteById(requerimiento.getCodReq());
		
	}
	
	@Test
	void testUpdateRequerimiento() {
		
		when(reqRepository.findById(requerimiento.getCodReq())).thenReturn(Optional.of(requerimiento));
		when(reqRepository.save(requerimiento)).thenReturn(requerimiento);
		
		assertNotNull(reqService.updateRequerimiento(requerimiento));
		
	}
}
