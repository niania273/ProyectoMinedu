package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.Solicitante;

public interface SolicitanteRepository extends JpaRepository <Solicitante, String>{
	
}
