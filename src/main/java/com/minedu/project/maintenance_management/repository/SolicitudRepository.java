package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Solicitud;

public interface SolicitudRepository extends JpaRepository <Solicitud, String>{
	
	@Query("SELECT s.codSol FROM Solicitud s ORDER BY s.codSol DESC LIMIT 1")
    String findUltimoCodigo();
}
