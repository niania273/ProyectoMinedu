package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "DISTRITO")
public class Distrito {
	
	@Id
	@Column (name = "COD_DIS", length = 6, nullable = false)
	private String codDis;
	
	@Column (name = "NOM_DIS", length = 40, nullable = false)
	private String nomDis;
	
	@ManyToOne
	@JoinColumn (name = "COD_PRO", nullable = false)
	private Provincia provincia;

	public Distrito() {
		// TODO Auto-generated constructor stub
	}

	public String getCodDis() {
		return codDis;
	}

	public void setCodDis(String codDis) {
		this.codDis = codDis;
	}

	public String getNomDis() {
		return nomDis;
	}

	public void setNomDis(String nomDis) {
		this.nomDis = nomDis;
	}
	
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
