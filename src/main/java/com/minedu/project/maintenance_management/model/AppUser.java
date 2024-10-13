package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "COD_USU")
	private int codUsu;
	
	@Column (name = "NOM_USU", length = 100, nullable = false)
	private String nomUsu;
	
	@Column (name = "APE_USU", length = 100, nullable = false)
	private String apeUsu;
	
	@Column (name = "EMA_USU", unique = true, length = 100, nullable = false)
	private String emaUsu;
	
	@Column (name = "CON_USU", length = 100, nullable = false)
	private String conUsu;
	
	@Column (name = "ROL_USU", length = 50, nullable = false)
	private String rolUsu;
	
	@Column (name = "FEC_CRE", nullable = false)
	private Date fecCre;

	public int getCodUsu() {
		return codUsu;
	}

	public void setCodUsu(int codUsu) {
		this.codUsu = codUsu;
	}

	public String getNomUsu() {
		return nomUsu;
	}

	public void setNomUsu(String nomUsu) {
		this.nomUsu = nomUsu;
	}

	public String getApeUsu() {
		return apeUsu;
	}

	public void setApeUsu(String apeUsu) {
		this.apeUsu = apeUsu;
	}

	public String getEmaUsu() {
		return emaUsu;
	}

	public void setEmaUsu(String emaUsu) {
		this.emaUsu = emaUsu;
	}

	public String getConUsu() {
		return conUsu;
	}

	public void setConUsu(String conUsu) {
		this.conUsu = conUsu;
	}

	public String getRolUsu() {
		return rolUsu;
	}

	public void setRolUsu(String rolUsu) {
		this.rolUsu = rolUsu;
	}

	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}
}
