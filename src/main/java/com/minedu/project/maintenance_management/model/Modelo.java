package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "MODELO")
public class Modelo {
	
	@Id
	@Column (name = "COD_MOD", length = 5, nullable = false)
	private String codMod;
	
	@Column (name = "NOM_MOD", length = 60, nullable = false)
	private String nomMod;
	
	@ManyToOne
	@JoinColumn (name = "COD_MAR", nullable = false)
	private Marca marca;

	public Modelo() {
		// TODO Auto-generated constructor stub
	}

	public String getCodMod() {
		return codMod;
	}

	public void setCodMod(String codMod) {
		this.codMod = codMod;
	}

	public String getNomMod() {
		return nomMod;
	}

	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
}
