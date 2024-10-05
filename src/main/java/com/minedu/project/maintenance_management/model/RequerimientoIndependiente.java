package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO_INDEPENDIENTE	")
public class RequerimientoIndependiente extends Requerimiento{
	
	@Column (name = "PRI_REQ", length = 50, nullable = true)
	private double priReq;
	
	@Column (name = "REC_REQ", length = 50, nullable = true)
	private String recReq;

	public double getPriReq() {
		return priReq;
	}

	public void setPriReq(double priReq) {
		this.priReq = priReq;
	}

	public String getRecReq() {
		return recReq;
	}

	public void setRecReq(String recReq) {
		this.recReq = recReq;
	}
}
