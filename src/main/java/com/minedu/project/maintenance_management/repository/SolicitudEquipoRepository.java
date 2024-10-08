package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.SolicitudEquipo;
import com.minedu.project.maintenance_management.model.SolicitudEquipoPK;

public interface SolicitudEquipoRepository extends JpaRepository <SolicitudEquipo, SolicitudEquipoPK>{

}
