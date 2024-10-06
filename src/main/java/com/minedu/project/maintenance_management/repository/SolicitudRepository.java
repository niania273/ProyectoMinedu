package com.minedu.project.maintenance_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.minedu.project.maintenance_management.model.Solicitud;

public interface SolicitudRepository extends JpaRepository <Solicitud, String>{

	@Query(value="SELECT * FROM SOLICITUD E WHERE E.DES_SOL LIKE CONCAT('%', :keyword, '%')", nativeQuery=true)
	List<Solicitud> findByKeyword(@Param("keyword") String keyword);
}
