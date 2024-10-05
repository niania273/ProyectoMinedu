package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "PROVINCIA")
public class Provincia {

	@Id
	@Column (name = "COD_PRO", length = 4, nullable = false)
	private String codPro;
	
	@Column (name = "NOM_PRO", length = 40, nullable = false)
	private String nomPro;
	
	@ManyToOne
	@JoinColumn (name = "COD_DEP", nullable = false)
	private Departamento departamento;

	public Provincia() {
		// TODO Auto-generated constructor stub
	}

	public String getCodPro() {
		return codPro;
	}

	public void setCodPro(String codPro) {
		this.codPro = codPro;
	}

	public String getNomPro() {
		return nomPro;
	}

	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
}
