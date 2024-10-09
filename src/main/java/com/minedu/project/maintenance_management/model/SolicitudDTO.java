package com.minedu.project.maintenance_management.model;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class SolicitudDTO {
	
	private String codSol;
	
	@NotEmpty(message = "La descripción es requerida.")
	private String desSol;
	private String catSol;
	private String nivPri;
	private String estSol;
	
	private String codSoli;
	@NotEmpty(message = "El DNI es requerido.")
	private String dniSoli;
	@NotEmpty(message = "El nombre es requerido.")
	private String nomSoli;
	@NotEmpty(message = "El apellido es requerido.")
	private String apeSoli;
	@NotEmpty(message = "El email es requerido.")
	@Email
	private String emaSoli;
	@NotEmpty(message = "El teléfono es requerido.")
	private String telSoli;
	
	private List<SolicitudEquipo> equipos;
	
	public List<SolicitudEquipo> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<SolicitudEquipo> equipos) {
		this.equipos = equipos;
	}
	public String getCodSol() {
		return codSol;
	}
	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}
	
	public String getDesSol() {
		return desSol;
	}
	public void setDesSol(String desSol) {
		this.desSol = desSol;
	}
	public String getCatSol() {
		return catSol;
	}
	public void setCatSol(String catSol) {
		this.catSol = catSol;
	}
	public String getNivPri() {
		return nivPri;
	}
	public void setNivPri(String nivPri) {
		this.nivPri = nivPri;
	}
	public String getEstSol() {
		return estSol;
	}
	public void setEstSol(String estSol) {
		this.estSol = estSol;
	}
	
	public String getCodSoli() {
		return codSoli;
	}
	public void setCodSoli(String codSoli) {
		this.codSoli = codSoli;
	}
	public String getDniSoli() {
		return dniSoli;
	}
	public void setDniSoli(String dniSoli) {
		this.dniSoli = dniSoli;
	}
	public String getNomSoli() {
		return nomSoli;
	}
	public void setNomSoli(String nomSoli) {
		this.nomSoli = nomSoli;
	}
	public String getApeSoli() {
		return apeSoli;
	}
	public void setApeSoli(String apeSoli) {
		this.apeSoli = apeSoli;
	}
	public String getEmaSoli() {
		return emaSoli;
	}
	public void setEmaSoli(String emaSoli) {
		this.emaSoli = emaSoli;
	}
	public String getTelSoli() {
		return telSoli;
	}
	public void setTelSoli(String telSoli) {
		this.telSoli = telSoli;
	}
}
