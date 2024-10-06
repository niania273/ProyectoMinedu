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
	
	@Column (name = "DES_SOL", length = 100, nullable = true)
	private String desSol;
	
	@Column (name = "CAT_SOL", length = 60, nullable = false)
	private String catSol;
	
	@Column (name = "NIV_PRI", length = 50, nullable = false)
	private String nivPri;
	
	@Column (name = "EST_SOL", length = 50, nullable = false)
	private String estSol;
	
	@Column(name = "FEC_CRE", nullable = false, updatable = true)
	private Date fecCre;
	
	@Column(name = "FEC_ACT", insertable = false, updatable = true)
	private Date fecAct;

	public Solicitud() {
		// TODO Auto-generated constructor stub
		 this.fecCre = new Date(System.currentTimeMillis());
		 this.fecAct = new Date(System.currentTimeMillis());
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
	
	public String getCatSol() {
		return catSol;
	}

	public void setCatSol(String catSol) {
		this.catSol = catSol;
	}
	
	public String getNivPri() {
		return nivPri;
	}

	public void setNivPri(String nivPri) {
		this.nivPri = nivPri;
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
	
}
