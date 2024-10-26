package com.minedu.project.maintenance_management.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SolicitudControllerTest {
	
	 @Autowired
	    private MockMvc mockMvc;

	    // SECTION: GET
	    @WithMockUser(roles = "USAU") // Mocking user with "USAU" role
	    @Test
	    public void shouldReturn200WhenGetSolicitudes() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/solicitudes")
	                .contentType(MediaType.TEXT_HTML))
	            .andExpect(status().isOk())
	            .andExpect(view().name("Solicitudes/Solicitudes"))
	            .andExpect(MockMvcResultMatchers
	                    .content()
	                    .contentTypeCompatibleWith(MediaType.TEXT_HTML));
	    }

	    @WithMockUser(roles = "USAU")
	    @Test
	    public void shouldReturn302WhenGetSolicitudByIdNotFound() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/solicitudes/ver/ST999"))
	            .andExpect(status().isFound());
	    }

	    // SECTION: POST
	    @WithMockUser(roles = "LOG") // Mocking user with "LOG" role for restricted action
	    @Test
	    public void shouldReturn403WhenUserNotAuthorized() throws Exception {
	        String solicitudJSON = "{\"codSol\":\"ST101\", \"codSoli\":\"SL101\", \"catSol\":\"Software\", \"nivPri\":\"Alta\", \"estSol\":\"Aprobada\"}";

	        mockMvc.perform(MockMvcRequestBuilders.post("/solicitudes/editar/ST101")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(solicitudJSON))
	            .andExpect(status().isForbidden());
	    }
}
