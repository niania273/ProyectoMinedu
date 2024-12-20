package com.minedu.project.maintenance_management.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO")
public class Requerimiento {

	@Id
	@Column (name = "COD_REQ", length = 5, nullable = false)
	private String codReq;
	
	@OneToOne
	@JoinColumn (name = "COD_SOL", nullable = false)
	private Solicitud solicitud;
	
	@ManyToOne
	@JoinColumn (name = "COD_SUM", nullable = false)
	private Suministrador suministrador;
	
	@Column (name = "TIT_REQ", length = 80, nullable = false)
	private String titReq;
	
	@Column (name = "DES_REQ", length = 100, nullable = false)
	private String desReq;
	
	@Column (name = "PLA_EJE_REQ", length = 80, nullable = false)
	private String plaEjeReq;
	
	@Column (name = "PRE_REQ", nullable = false)
	private double preReq;
	
	@Column (name = "FEC_LIM", nullable = true)
	private LocalDate fecLim;
	
	@Column (name = "EST_REQ", length = 50, nullable = true)
	private String estReq;
	
	@Column (name = "FEC_CRE", nullable = false)
	private LocalDate fecCre;
	
	@Column (name = "FEC_ACT", nullable = false)
	private LocalDate fecAct;
	
	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

	public String getCodReq() {
		return codReq;
	}

	public void setCodReq(String codReq) {
		this.codReq = codReq;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Suministrador getSuministrador() {
		return suministrador;
	}

	public void setSuministrador(Suministrador suministrador) {
		this.suministrador = suministrador;
	}

	public String getTitReq() {
		return titReq;
	}

	public void setTitReq(String titReq) {
		this.titReq = titReq;
	}

	public String getDesReq() {
		return desReq;
	}

	public void setDesReq(String desReq) {
		this.desReq = desReq;
	}

	public String getPlaEjeReq() {
		return plaEjeReq;
	}

	public void setPlaEjeReq(String plaEjeReq) {
		this.plaEjeReq = plaEjeReq;
	}

	public double getPreReq() {
		return preReq;
	}

	public void setPreReq(double preReq) {
		this.preReq = preReq;
	}

	public LocalDate getFecLim() {
		return fecLim;
	}

	public void setFecLim(LocalDate fecLim) {
		this.fecLim = fecLim;
	}

	public String getEstReq() {
		return estReq;
	}

	public void setEstReq(String estReq) {
		this.estReq = estReq;
	}

	public LocalDate getFecCre() {
		return fecCre;
	}

	public void setFecCre(LocalDate fecCre) {
		this.fecCre = fecCre;
	}

	public LocalDate getFecAct() {
		return fecAct;
	}

	public void setFecAct(LocalDate fecAct) {
		this.fecAct = fecAct;
	}
}
