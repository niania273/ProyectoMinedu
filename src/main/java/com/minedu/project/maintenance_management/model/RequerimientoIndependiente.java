package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO_INDEPENDIENTE	")
public class RequerimientoIndependiente extends Requerimiento{
	
	@Column (name = "MON_EST", nullable = true)
	private double monEst;
	
	@Column (name = "CON_REQ", length = 80, nullable = true)
	private String conReq;

	public double getMonEst() {
		return monEst;
	}

	public void setMonEst(double monEst) {
		this.monEst = monEst;
	}

	public String getConReq() {
		return conReq;
	}

	public void setConReq(String conReq) {
		this.conReq = conReq;
	}
}
