package com.minedu.project.maintenance_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.minedu.project.maintenance_management.service.RequerimientoService;
import com.minedu.project.maintenance_management.service.SolicitudService;

@RestController
public class RequerimientoRestController {
	
	@Autowired
	private RequerimientoService reqService;
	
	
}
