package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table (name = "SOLICITUD")
public class Solicitud {
	
	@Id
	@Column (name = "COD_SOL", length = 5, nullable = false)
	private String codSol;
	
	@OneToOne
	@JoinColumn (name = "COD_SOLI", nullable = false)
	private Solicitante solicitante;
	
	@Column (name = "DES_SOL", length = 60, nullable = true)
	private String desSol;
	
	@Column (name = "NIV_CLA", length = 1, nullable = true)
	private String nivCla;
	
	@Column (name = "EST_SOL", length = 50, nullable = false)
	private String estSol;
	
	@Column (name = "FEC_CRE", length = 5, nullable = false)
	private Date fecCre;
	
	@Column (name = "FEC_ACT", length = 5, nullable = false)
	private Date fecAct;
	
	@ManyToOne
	@JoinColumn (name = "COD_EMP", nullable = false)
	private Empleado empleado;

	public Solicitud() {
		// TODO Auto-generated constructor stub
	}

	public String getCodSol() {
		return codSol;
	}

	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}

	public String getDesSol() {
		return desSol;
	}

	public void setDesSol(String desSol) {
		this.desSol = desSol;
	}

	public String getNivCla() {
		return nivCla;
	}

	public void setNivCla(String nivCla) {
		this.nivCla = nivCla;
	}

	public String getEstSol() {
		return estSol;
	}

	public void setEstSol(String estSol) {
		this.estSol = estSol;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public Date getFecAct() {
		return fecAct;
	}

	public void setFecAct(Date fecAct) {
		this.fecAct = fecAct;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
}
