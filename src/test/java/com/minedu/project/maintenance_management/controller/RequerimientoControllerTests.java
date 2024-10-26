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
public class RequerimientoControllerTests {
	
	@Autowired
    private MockMvc mockMvc;

    // SECTION: GET
    
    @WithMockUser(roles = "USAU") // Use role instead of username
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

    @WithMockUser(roles = "USAU")
    @Test
    void shallReturn302WhenGetRequerimientoByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/requerimientos/detalles/RQ999"))
                .andExpect(status().isFound());
    }

    // SECTION: POST

    @WithMockUser(roles = "USAU")
    @Test
    void shallReturn403WhenUserAccessDenied() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/requerimientos/actualizar/RQ101")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isForbidden());
    }

}
