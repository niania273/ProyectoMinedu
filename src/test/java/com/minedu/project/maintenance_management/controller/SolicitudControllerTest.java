package com.minedu.project.maintenance_management.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SolicitudControllerTest {
	/*
	@Autowired
	private MockMvc mockMvc;
	
	//Métodos GET
	@Test
	public void shouldReturn200WhenGetSolicitudes() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/solicitudes")
				.with(user("f.luciacanales@gmail.com").password("fabiana1").authorities(new SimpleGrantedAuthority("USAU"))))
			.andExpect(status().isOk())
			.andExpect(view().name("Solicitudes/Solicitudes"))
			.andExpect(MockMvcResultMatchers
					.content()
					.contentTypeCompatibleWith(MediaType.TEXT_HTML));
	}
	
	@Test
	public void shouldReturn302WhenGetSolicitudByIdNotFound() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/solicitudes/ver/ST999")
	            .with(user("f.luciacanales@gmail.com").authorities(new SimpleGrantedAuthority("USAU"))))
	        .andExpect(status().isFound());
	}
	
	//Métodos POST
	@Test
	public void shouldReturn403WhenUserNotAuthorized() throws Exception {
		String solicitudJSON = "{\"codSol\":\"ST101\", \"codSoli\":\"SL101\", \"catSol\":\"Software\", \"nivPri\":\"Alta\", \"estSol\":\"Aprobada\"}";
		
	    mockMvc.perform(MockMvcRequestBuilders.post("/solicitudes/editar/ST101")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(solicitudJSON)
	            .with(user("canalesfabiana@gmail.com").authorities(new SimpleGrantedAuthority("LOG"))))
	        .andExpect(status().isForbidden());
	}*/
}
