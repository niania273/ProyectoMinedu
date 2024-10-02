package com.minedu.project.maintenance_management.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.Solicitud;

public interface SolicitudRepository extends JpaRepository <Solicitud, String>{

}
