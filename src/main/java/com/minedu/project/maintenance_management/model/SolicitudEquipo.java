package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "SOLICITUD_EQUIPO")
@IdClass(SolicitudEquipoPK.class)
public class SolicitudEquipo {
	
	@Id
	@Column (name = "COD_SOL", length = 5, nullable = false)
	private String codSol;
	
	@Id
	@Column (name = "COD_EQU", length = 5, nullable = false)
	private String codEqu;
	
	@Column (name = "CAN_EQU", nullable = false)
	private Byte canEqu;

	public SolicitudEquipo() {
		// TODO Auto-generated constructor stub
	}

	public String getCodSol() {
		return codSol;
	}

	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public String getCodEqu() {
		return codEqu;
	}

	public void setCodEqu(String codEqu) {
		this.codEqu = codEqu;
	}

	public Byte getCanEqu() {
		return canEqu;
	}

	public void setCanEqu(Byte canEqu) {
		this.canEqu = canEqu;
	}
}
