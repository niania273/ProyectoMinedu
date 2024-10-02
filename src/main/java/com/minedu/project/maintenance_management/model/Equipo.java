package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "EQUIPO")
public class Equipo {

	@Id
	@Column (name = "COD_EQU", length = 5, nullable = false)
	private String codEqu;
	
	@Column (name = "NOM_EQU", length = 60, nullable = false)
	private String nomEqu;
	
	@ManyToOne
	@JoinColumn (name = "COD_MOD", nullable = false)
	private Modelo modelo;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	public String getCodEqu() {
		return codEqu;
	}

	public void setCodEqu(String codEqu) {
		this.codEqu = codEqu;
	}

	public String getNomEqu() {
		return nomEqu;
	}

	public void setNomEqu(String nomEqu) {
		this.nomEqu = nomEqu;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
}
