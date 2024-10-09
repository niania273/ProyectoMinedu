package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.Requerimiento;

public interface RequerimientoRepository extends JpaRepository <Requerimiento, String>{
	void deleteBySolicitud_CodSol(String codSol);
}
