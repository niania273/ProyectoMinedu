package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "INCIDENTE")
public class Incidente {

	@Id
	@Column (name = "COD_INC", length = 5, nullable = false)
	private String codInc;
	
	@Column (name = "NIV_INC", length = 40, nullable = false)
	private String nivInc;

	public Incidente() {
		// TODO Auto-generated constructor stub
	}

	public String getCodInc() {
		return codInc;
	}

	public void setCodInc(String codInc) {
		this.codInc = codInc;
	}

	public String getNivInc() {
		return nivInc;
	}

	public void setNivInc(String nivInc) {
		this.nivInc = nivInc;
	}
}
