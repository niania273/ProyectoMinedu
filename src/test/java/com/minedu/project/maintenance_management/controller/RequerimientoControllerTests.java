package com.minedu.project.maintenance_management.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.minedu.project.maintenance_management.model.Requerimiento;
import com.minedu.project.maintenance_management.model.Suministrador;
import com.minedu.project.maintenance_management.model.Solicitud;
import com.minedu.project.maintenance_management.service.ReporteService;
import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;
import com.minedu.project.maintenance_management.service.SuministradorService;

import net.sf.jasperreports.engine.JRException;

@SpringBootTest
@AutoConfigureMockMvc
public class RequerimientoControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	//SECCION: GET
	@WithMockUser(username = "santiagodsrussian@gmail.com", roles = "USAU")
	@Test
	void shallReturn200WhenGetRequerimientos() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/requerimientos")
	            .contentType(MediaType.TEXT_HTML))  
	            .andExpect(status().isOk())          
	            .andExpect(view().name("Requerimiento/Requerimientos")) 
	            .andExpect(MockMvcResultMatchers
	                        .content()
	                        .contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
	
	@WithMockUser(username = "santiagodsrussian@gmail.com", roles = "USAU")
	@Test
	void shallReturn302WhenGetRequerimientoByIdNotFound() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/requerimientos/detalles/RQ999"))
				.andExpect(status().isFound());
	}

	//SECCION: POST
	
	@WithMockUser(username = "santiagodsrussian@gmail.com", roles = "USAU")
	@Test
	void shallReturn403WhenUserAccessDenied() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.post("/requerimientos/actualizar/RQ101")
				.contentType(MediaType.TEXT_HTML))
				.andExpect(status().isForbidden());
		
	}

}
