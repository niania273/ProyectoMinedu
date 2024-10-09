package com.minedu.project.maintenance_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.model.SolicitudEquipoPK;

public interface SolicitudEquipoRepository extends JpaRepository <SolicitudEquipo, SolicitudEquipoPK>{
	
	void deleteBySolicitud_CodSol(String codSol);
	List<SolicitudEquipo> findBySolicitud_CodSol(String codSol);
}
