package com.minedu.project.maintenance_management.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.minedu.project.maintenance_management.model.AppUser;
import com.minedu.project.maintenance_management.model.RegisterDTO;
import com.minedu.project.maintenance_management.repository.AppUserRepository;

import jakarta.validation.Valid;

@Controller
public class AccountController {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@GetMapping("/register")
	public String register(Model model) {
		RegisterDTO registerDTO = new RegisterDTO();
		model.addAttribute("registerDTO", registerDTO);
		model.addAttribute("success", false);
		return "Register";
	}
	
	@PostMapping("/register")
	public String register(Model model, @Valid @ModelAttribute RegisterDTO registerDTO, BindingResult result) {
		
		if (!registerDTO.getConUsu().equals(registerDTO.getConfCon())) {
			result.addError(new FieldError("registerDTO", "confCon", "Contraseña y Contraseña confirmada no son iguales")
			);
		}
		
		AppUser appUser = appUserRepository.findByEmaUsu(registerDTO.getEmaUsu());
		if(appUser != null) {
			result.addError(new FieldError("registerDTO", "emaUsu", "El email ya ha es utilizado")
			);
		}
		
		if(result.hasErrors()) {
			return "Register";
		}
		
		try {
			
			var bCryptEncoder = new BCryptPasswordEncoder();
			
			AppUser nuevoUsuario = new AppUser();
			nuevoUsuario.setNomUsu(registerDTO.getNomUsu());
			nuevoUsuario.setApeUsu(registerDTO.getApeUsu());
			nuevoUsuario.setEmaUsu(registerDTO.getEmaUsu());
			nuevoUsuario.setRolUsu(registerDTO.getRolUsu());
			nuevoUsuario.setFecCre(java.sql.Date.valueOf(LocalDate.now()));
			nuevoUsuario.setConUsu(bCryptEncoder.encode(registerDTO.getConUsu()));
			
			appUserRepository.save(nuevoUsuario);
			
			model.addAttribute("registerDTO", new RegisterDTO());
			model.addAttribute("success", true);
			
		} catch (Exception e) {
			result.addError(new FieldError("registerDTO", "nomUsu", e.getMessage())
			);
		}
		
		return "Register";
	}
	
	@GetMapping("/perfil")
	public String mostrarPerfil(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		String email = "";
		if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            email = userDetails.getUsername();
		}
		
		AppUser appUser = appUserRepository.findByEmaUsu(email);
		
		model.addAttribute("usuario", appUser);
		
		return "Perfil";
	}
}
