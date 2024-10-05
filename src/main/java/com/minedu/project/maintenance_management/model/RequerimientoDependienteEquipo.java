package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO_DEPENDIENTE_EQUIPO")
@IdClass(RequerimientoDependienteEquipoPK.class)
public class RequerimientoDependienteEquipo {

	@Id
	@ManyToOne
    @JoinColumn(name = "COD_REQ", nullable = false)
    private RequerimientoDependiente requerimientoDependiente;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_EQU", nullable = false)
    private Equipo equipo;
	
	@Column (name = "CON_EQU", length = 50, nullable = false)
	private String conEqu;

	public RequerimientoDependienteEquipo() {
		// TODO Auto-generated constructor stub
	}

	public RequerimientoDependiente getRequerimientoDependiente() {
		return requerimientoDependiente;
	}

	public void setRequerimientoDependiente(RequerimientoDependiente requerimientoDependiente) {
		this.requerimientoDependiente = requerimientoDependiente;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getConEqu() {
		return conEqu;
	}

	public void setConEqu(String conEqu) {
		this.conEqu = conEqu;
	}
}
