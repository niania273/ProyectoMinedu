package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Solicitante;

public interface SolicitanteRepository extends JpaRepository <Solicitante, String>{
	
	@Query("SELECT s.codSoli FROM Solicitante s ORDER BY s.codSoli DESC LIMIT 1")
    String findUltimoCodigo();
}
