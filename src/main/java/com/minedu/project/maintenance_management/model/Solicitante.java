package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "SOLICITANTE")
public class Solicitante {
	
	@Id
	@Column (name = "COD_SOLI", length = 5, nullable = false)
	private String codSoli;
	
	@Column (name = "DNI_SOLI", length = 8, nullable = false)
	private String dniSoli;
	
	@Column (name = "NOM_SOLI", length = 60, nullable = false)
	private String nomSoli;
	
	@Column (name = "APE_SOLI", length = 60, nullable = false)
	private String apeSoli;
	
	@Column (name = "EMA_SOLI", length = 80, nullable = true)
	private String emaSoli;
	
	@Column (name = "TEL_SOLI", length = 9, nullable = true)
	private String telSoli;

	public Solicitante() {
		// TODO Auto-generated constructor stub
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
