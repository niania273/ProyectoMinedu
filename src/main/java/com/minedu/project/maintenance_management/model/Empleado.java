package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table (name = "EMPLEADO")
public class Empleado {

	@Id
	@Column (name = "COD_EMP", length = 5, nullable = false)
	private String codEmp;
	
	@Column (name = "DNI_EMP", length = 8, nullable = false)
	private String dniEmp;
	
	@Column (name = "NOM_EMP", length = 60, nullable = false)
	private String nomEmp;
	
	@Column (name = "APE_EMP", length = 60, nullable = false)
	private String apeEmp;
	
	@Column (name = "EMA_EMP", length = 80, nullable = true)
	private String emaEmp;
	
	@Column (name = "FEC_EMP", nullable = true)
	private Date fecNacEmp;
	
	@Column (name = "TEL_EMP", length = 9, nullable = true)
	private String telEmp;
	
	@Column (name = "SEXO_EMP", length = 1, nullable = true)
	private String sexoEmp;

	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public String getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(String codEmp) {
		this.codEmp = codEmp;
	}

	public String getDniEmp() {
		return dniEmp;
	}

	public void setDniEmp(String dniEmp) {
		this.dniEmp = dniEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getApeEmp() {
		return apeEmp;
	}

	public void setApeEmp(String apeEmp) {
		this.apeEmp = apeEmp;
	}

	public String getEmaEmp() {
		return emaEmp;
	}

	public void setEmaEmp(String emaEmp) {
		this.emaEmp = emaEmp;
	}

	public Date getFecNacEmp() {
		return fecNacEmp;
	}

	public void setFecNacEmp(Date fecNacEmp) {
		this.fecNacEmp = fecNacEmp;
	}

	public String getTelEmp() {
		return telEmp;
	}

	public void setTelEmp(String telEmp) {
		this.telEmp = telEmp;
	}

	public String getSexoEmp() {
		return sexoEmp;
	}

	public void setSexoEmp(String sexoEmp) {
		this.sexoEmp = sexoEmp;
	}
}
