package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "ID_USU")
	private int idUsu;
	
	@Column(name = "NOM_USU", length = 100, nullable = false)
    private String nomUsu;
	
	@Column(name = "APE_USU", length = 100, nullable = false)
    private String apeUsu;
	
	@Column(name = "EMA_USU", length = 100, nullable = false)
    private String emaUsu;

	@Column(name = "CON_USU", length = 100, nullable = false)
    private String conUsu;
	
	@Column(name = "ROL_USU", length = 50, nullable = false)
    private String rolUsu;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
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
}
