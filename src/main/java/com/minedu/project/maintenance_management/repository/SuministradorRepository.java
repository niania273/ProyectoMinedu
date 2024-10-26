package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Suministrador;

public interface SuministradorRepository extends JpaRepository <Suministrador, String> {
	@Query("SELECT s.codSum FROM Suministrador s ORDER BY s.codSum DESC LIMIT 1")
    String findUltimoCodigo();
}
