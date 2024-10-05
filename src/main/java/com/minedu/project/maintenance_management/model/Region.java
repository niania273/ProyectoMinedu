package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REGION")
public class Region {

	@Id
	@Column (name = "COD_REG", length = 6, nullable = false)
	private String codReg;
	
	@Column (name = "NOM_REG", length = 40, nullable = false)
	private String nomReg;

	public Region() {
		// TODO Auto-generated constructor stub
	}

	public String getCodReg() {
		return codReg;
	}

	public void setCodReg(String codReg) {
		this.codReg = codReg;
	}

	public String getNomReg() {
		return nomReg;
	}

	public void setNomReg(String nomReg) {
		this.nomReg = nomReg;
	}
}
