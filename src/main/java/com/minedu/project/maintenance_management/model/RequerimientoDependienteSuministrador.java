package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO_DEPENDIENTE_SUMINISTRADOR")
@IdClass(RequerimientoDependienteSuministradorPK.class)
public class RequerimientoDependienteSuministrador {

	@Id
	@ManyToOne
    @JoinColumn(name = "COD_REQ", nullable = false)
    private RequerimientoDependiente requerimientoDependiente;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "COD_SUM", nullable = false)
    private Suministrador suministrador;
	
	@Column (name = "CON_SUM", length = 50, nullable = false)
	private String conSum;

	public RequerimientoDependienteSuministrador() {
		// TODO Auto-generated constructor stub
	}

	public RequerimientoDependiente getRequerimientoDependiente() {
		return requerimientoDependiente;
	}

	public void setRequerimientoDependiente(RequerimientoDependiente requerimientoDependiente) {
		this.requerimientoDependiente = requerimientoDependiente;
	}

	public Suministrador getSuministrador() {
		return suministrador;
	}

	public void setSuministrador(Suministrador suministrador) {
		this.suministrador = suministrador;
	}

	public String getConSum() {
		return conSum;
	}

	public void setConSum(String conSum) {
		this.conSum = conSum;
	}
}
