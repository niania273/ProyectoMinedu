package com.minedu.project.maintenance_management.model;

import java.sql.Date;

public class RequerimientoForm {
	
	private String codReq;
	
	private String codSol;
	
	private String codSum;
	
	private String titReq;
	
	private String desReq;
	
	private String plaEjeReq;
	
	private double preReq;
	
	private Date fecLim;
	
	private String estReq;
	
	private Date fecCre;
	
	private Date fecAct;

	public String getCodReq() {
		return codReq;
	}

	public void setCodReq(String codReq) {
		this.codReq = codReq;
	}

	public String getCodSol() {
		return codSol;
	}

	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public String getCodSum() {
		return codSum;
	}

	public void setCodSum(String codSum) {
		this.codSum = codSum;
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

	public Date getFecLim() {
		return fecLim;
	}

	public void setFecLim(Date fecLim) {
		this.fecLim = fecLim;
	}

	public String getEstReq() {
		return estReq;
	}

	public void setEstReq(String estReq) {
		this.estReq = estReq;
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
}
