package com.minedu.project.maintenance_management.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.repository.RequerimientoRepository;
import com.minedu.project.maintenance_management.repository.SolicitudRepository;
import com.minedu.project.maintenance_management.repository.SuministradorRepository;
import com.minedu.project.maintenance_management.service.RequerimientoService;

import jakarta.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RequerimientoServiceTests {
	
	@Mock
	private RequerimientoRepository reqRepository;
	
	private Requerimiento requerimiento;
	
	@InjectMocks
	private RequerimientoService reqService;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		
		requerimiento = new Requerimiento();
		requerimiento.setCodReq("RQ999");
		requerimiento.setSolicitud(new Solicitud());
		requerimiento.setSuministrador(new Suministrador());
		requerimiento.setTitReq("Du isst das Kind");
		requerimiento.setDesReq("Einen Apfel");
		requerimiento.setPlaEjeReq("Nein");
		requerimiento.setPreReq(30.50);
		requerimiento.setFecLim(LocalDate.now());
		requerimiento.setFecCre(LocalDate.now());
		requerimiento.setFecAct(LocalDate.now());
	}
	
	@Test
	void findAllRequerimientos() {
		
		when(reqRepository.findAll()).thenReturn(Arrays.asList(requerimiento));
		assertNotNull(reqService.findAllRequerimientos());
	}
	
	@Test
	void findRequerimientoById() {
		
	}
	
}
