package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Requerimiento;

public interface RequerimientoRepository extends JpaRepository <Requerimiento, String>{
	void deleteBySolicitud_CodSol(String codSol);
	@Query("SELECT s.codSol FROM Solicitud s ORDER BY s.codSol DESC LIMIT 1")
    String findUltimoCodigo();
}
