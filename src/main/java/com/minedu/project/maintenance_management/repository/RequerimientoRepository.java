package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Requerimiento;

public interface RequerimientoRepository extends JpaRepository <Requerimiento, String>{
	void deleteBySolicitud_CodSol(String codSol);
	@Query("SELECT r.codReq FROM Requerimiento r ORDER BY r.codReq DESC LIMIT 1")
    String findUltimoCodigo();
}
