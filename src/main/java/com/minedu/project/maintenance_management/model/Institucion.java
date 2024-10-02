package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "INSTITUCION")
public class Institucion {

	@Id
	@Column (name = "COD_INS", length = 5, nullable = false)
	private String codIns;
	
	@Column (name = "COD_MOD", length = 7, nullable = false)
	private String codEmp;
	
	@Column (name = "NOM_INS", length = 80, nullable = false)
	private String nomIns;
	
	@Column (name = "TEL_INS", length = 7, nullable = true)
	private String telIns;
	
	@Column (name = "EMA_INS", length = 80, nullable = true)
	private String emaIns;
	
	@Column (name = "NIV_EDU", length = 60, nullable = true)
	private String nivEdu;
	
	@Column (name = "DIR_INS", length = 80, nullable = true)
	private String dirIns;
	
	@ManyToOne
	@JoinColumn (name = "COD_DIS", nullable = false)
	private Distrito distrito;

	public Institucion() {
		// TODO Auto-generated constructor stub
	}

	public String getCodIns() {
		return codIns;
	}

	public void setCodIns(String codIns) {
		this.codIns = codIns;
	}

	public String getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getNomIns() {
		return nomIns;
	}

	public void setNomIns(String nomIns) {
		this.nomIns = nomIns;
	}

	public String getTelIns() {
		return telIns;
	}

	public void setTelIns(String telIns) {
		this.telIns = telIns;
	}

	public String getEmaIns() {
		return emaIns;
	}

	public void setEmaIns(String emaIns) {
		this.emaIns = emaIns;
	}

	public String getNivEdu() {
		return nivEdu;
	}

	public void setNivEdu(String nivEdu) {
		this.nivEdu = nivEdu;
	}

	public String getDirIns() {
		return dirIns;
	}

	public void setDirIns(String dirIns) {
		this.dirIns = dirIns;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
}
