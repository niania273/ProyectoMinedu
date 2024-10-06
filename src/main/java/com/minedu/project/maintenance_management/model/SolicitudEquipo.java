package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "SOLICITUD_EQUIPO")
@IdClass(SolicitudEquipoPK.class)
public class SolicitudEquipo {
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_SOL", nullable = false)
    private Solicitud solicitud;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_EQU", nullable = false)
    private Equipo equipo;
	
	@Column (name = "CAN_EQU", nullable = false)
	private Byte canEqu;

	public SolicitudEquipo() {
		// TODO Auto-generated constructor stub
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Byte getCanEqu() {
		return canEqu;
	}

	public void setCanEqu(Byte canEqu) {
		this.canEqu = canEqu;
	}
}
