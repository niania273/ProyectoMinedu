package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "DEPARTAMENTO")
public class Departamento {

	@Id
	@Column (name = "COD_DEP", length = 2, nullable = false)
	private String codDep;
	
	@Column (name = "NOM_DEP", length = 40, nullable = false)
	private String nomDep;
	
	@ManyToOne
	@JoinColumn (name = "COD_REG", nullable = false)
	private Region region;

	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public String getCodDep() {
		return codDep;
	}

	public void setCodDep(String codDep) {
		this.codDep = codDep;
	}

	public String getNomDep() {
		return nomDep;
	}

	public void setNomDep(String nomDep) {
		this.nomDep = nomDep;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
