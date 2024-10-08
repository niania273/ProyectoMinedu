package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minedu.project.maintenance_management.model.Equipo;

public interface EquipoRepository extends JpaRepository <Equipo, String> {
	@Query("SELECT e.codEqu FROM Equipo e ORDER BY e.codEqu DESC LIMIT 1")
    String findUltimoCodigo();
}
