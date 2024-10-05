package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table (name = "MANTENIMIENTO")
public class Mantenimiento {

	@Id
	@Column (name = "COD_MAN", length = 5, nullable = false)
	private String codMan;
	
	@OneToOne
	@JoinColumn (name = "COD_REQ", nullable = false)
	private Requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn (name = "COD_EMP", nullable = false)
	private Empleado empleado;
	
	@Column (name = "FEC_MAN", nullable = false)
	private Date fecMan;
	
	@Column (name = "OBS_MAN", length = 80, nullable = false)
	private String obsMan;
	
	@Column (name = "CAL_MAN", length = 1, nullable = false)
	private String calMan;
	
	@Column (name = "CON_MAN", length = 2, nullable = false)
	private String conMan;

	public Mantenimiento() {
		// TODO Auto-generated constructor stub
	}

	public String getCodMan() {
		return codMan;
	}

	public void setCodMan(String codMan) {
		this.codMan = codMan;
	}

	public Requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(Requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFecMan() {
		return fecMan;
	}

	public void setFecMan(Date fecMan) {
		this.fecMan = fecMan;
	}

	public String getObsMan() {
		return obsMan;
	}

	public void setObsMan(String obsMan) {
		this.obsMan = obsMan;
	}

	public String getCalMan() {
		return calMan;
	}

	public void setCalMan(String calMan) {
		this.calMan = calMan;
	}

	public String getConMan() {
		return conMan;
	}

	public void setConMan(String conMan) {
		this.conMan = conMan;
	}
}
