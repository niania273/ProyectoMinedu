package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "SUMINISTRADOR")
public class Suministrador {
	
	@Id
	@Column (name = "COD_SUM", length = 5, nullable = false)
	private String codSum;
	
	@Column (name = "RUC_SUM", length = 11, nullable = false)
	private String rucSum;
	
	@Column (name = "NOM_SUM", length = 80, nullable = false)
	private String nomSum;
	
	@Column (name = "TEL_SUM", length = 7, nullable = false)
	private String telSum;
	
	@Column (name = "EMA_SUM", length = 70, nullable = false)
	private String emaSum;

	public Suministrador() {
		// TODO Auto-generated constructor stub
	}

	public String getCodSum() {
		return codSum;
	}

	public void setCodSum(String codSum) {
		this.codSum = codSum;
	}

	public String getRucSum() {
		return rucSum;
	}

	public void setRucSum(String rucSum) {
		this.rucSum = rucSum;
	}

	public String getNomSum() {
		return nomSum;
	}

	public void setNomSum(String nomSum) {
		this.nomSum = nomSum;
	}

	public String getTelSum() {
		return telSum;
	}

	public void setTelSum(String telSum) {
		this.telSum = telSum;
	}

	public String getEmaSum() {
		return emaSum;
	}

	public void setEmaSum(String emaSum) {
		this.emaSum = emaSum;
	}
}
