package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
@Table (name = "REQUERIMIENTO")
public abstract class Requerimiento {

	@Id
	@Column (name = "COD_REQ", length = 5, nullable = false)
	private String codSol;
	
	@OneToOne
	@JoinColumn (name = "COD_SOL", nullable = false)
	private Solicitud solicitud;
	
	@Column (name = "TIT_REQ", length = 80, nullable = false)
	private String titReq;
	
	@Column (name = "DES_REQ", length = 100, nullable = false)
	private String desReq;
	
	@Column (name = "EST_REQ", length = 50, nullable = false)
	private String estReq;
	
	@Column (name = "FEC_PRO", length = 5, nullable = true)
	private Date fecPro;
	
	@Column (name = "PLA_EJE_REQ", length = 80, nullable = false)
	private String plaEjeReq;
	
	@Column (name = "CAL_SER", length = 30, nullable = true)
	private String calSer;
	
	@Column (name = "OBS_REQ", length = 100, nullable = true)
	private String obsReq;
	
	@Column (name = "FEC_CRE", length = 5, nullable = false)
	private Date fecCre;
	
	@Column (name = "FEC_ACT", length = 5, nullable = false)
	private Date fecAct;
	
	@ManyToOne
	@JoinColumn (name = "COD_EMP", nullable = false)
	private Empleado empleado;

	public Requerimiento() {
		// TODO Auto-generated constructor stub
	}

	public String getCodSol() {
		return codSol;
	}

	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
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

	public String getEstReq() {
		return estReq;
	}

	public void setEstReq(String estReq) {
		this.estReq = estReq;
	}

	public Date getFecPro() {
		return fecPro;
	}

	public void setFecPro(Date fecPro) {
		this.fecPro = fecPro;
	}

	public String getPlaEjeReq() {
		return plaEjeReq;
	}

	public void setPlaEjeReq(String plaEjeReq) {
		this.plaEjeReq = plaEjeReq;
	}

	public String getCalSer() {
		return calSer;
	}

	public void setCalSer(String calSer) {
		this.calSer = calSer;
	}

	public String getObsReq() {
		return obsReq;
	}

	public void setObsReq(String obsReq) {
		this.obsReq = obsReq;
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
