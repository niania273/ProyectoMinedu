package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "MARCA")
public class Marca {

	@Id
	@Column (name = "COD_MAR", length = 5, nullable = false)
	private String codMar;
	
	@Column (name = "NOM_MAR", length = 60, nullable = false)
	private String nomMar;

	public Marca() {
		// TODO Auto-generated constructor stub
	}

	public String getCodMar() {
		return codMar;
	}

	public void setCodMar(String codMar) {
		this.codMar = codMar;
	}

	public String getNomMar() {
		return nomMar;
	}

	public void setNomMar(String nomMar) {
		this.nomMar = nomMar;
	}
}
