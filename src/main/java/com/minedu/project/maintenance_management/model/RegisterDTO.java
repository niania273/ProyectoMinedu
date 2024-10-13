package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDTO {
	
	@NotEmpty(message = "El nombre es obligatorio")
	private String nomUsu;
	
	@NotEmpty(message = "El apellido es obligatorio")
	private String apeUsu;
	
	@NotEmpty(message = "El email es obligatorio")
	@Email
	private String emaUsu;
	
	@Size(min = 6, message = "La contraseña debe tener 8 caracteres como mínimo.")
	private String conUsu;
	private String rolUsu;
	private Date fecCre;
	private String confCon;
	
	
	public String getNomUsu() {
		return nomUsu;
	}
	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}
	public String getApeUsu() {
		return apeUsu;
	}
	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}
	public String getEmaUsu() {
		return emaUsu;
	}
	public void setEmaUsu(String emaUsu) {
		this.emaUsu = emaUsu;
	}
	public String getConUsu() {
		return conUsu;
	}
	public void setConUsu(String conUsu) {
		this.conUsu = conUsu;
	}
	public String getRolUsu() {
		return rolUsu;
	}
	public void setRolUsu(String rolUsu) {
		this.rolUsu = rolUsu;
	}
	public Date getFecCre() {
		return fecCre;
	}
	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}
	public String getConfCon() {
		return confCon;
	}
	public void setConfCon(String confCon) {
		this.confCon = confCon;
	}
}
