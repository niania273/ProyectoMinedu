package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "SOLICITUD_EQUIPO_INCIDENTE")
@IdClass(SolicitudEquipoIncidentePK.class)
public class SolicitudEquipoIncidente {

	@Id
	@ManyToOne
    @JoinColumn(name = "COD_SOL", nullable = false)
    private Solicitud solicitud;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_EQU", nullable = false)
    private Equipo equipo;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_INC", nullable = false)
    private Incidente incidente;
	
	@Column (name = "CAU_INC", length = 100, nullable = false)
	private String cauInc;
	
	@Column (name = "SOL_INC", length = 100, nullable = false)
	private String solInc;

	public SolicitudEquipoIncidente() {
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

	public Incidente getIncidente() {
		return incidente;
	}

	public void setIncidente(Incidente incidente) {
		this.incidente = incidente;
	}

	public String getCauInc() {
		return cauInc;
	}

	public void setCauInc(String cauInc) {
		this.cauInc = cauInc;
	}

	public String getSolInc() {
		return solInc;
	}

	public void setSolInc(String solInc) {
		this.solInc = solInc;
	}
}
