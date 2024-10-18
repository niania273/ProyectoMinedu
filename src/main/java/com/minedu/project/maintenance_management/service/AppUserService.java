package com.minedu.project.maintenance_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minedu.project.maintenance_management.model.AppUser;
import com.minedu.project.maintenance_management.repository.AppUserRepository;

@Service
public class AppUserService implements UserDetailsService{
	
	@Autowired
	private AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String emaUsu) throws UsernameNotFoundException {
		AppUser appUser = appUserRepository.findByEmaUsu(emaUsu);
		
		if (appUser != null) {
			var springUser = User.withUsername(appUser.getEmaUsu())
					.password(appUser.getConUsu())
					.authorities(appUser.getRolUsu())
					.build();
			return springUser;
		}
		
		return null;
	}

}
