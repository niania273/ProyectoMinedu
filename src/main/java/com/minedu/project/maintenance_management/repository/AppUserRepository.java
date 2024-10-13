package com.minedu.project.maintenance_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minedu.project.maintenance_management.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByEmaUsu(String emaUsu);
}
