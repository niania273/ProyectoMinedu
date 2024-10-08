package com.minedu.project.maintenance_management.model;

public class SolicitudDTO {
	
	private String codSol;
	private String desSol;
	private String catSol;
	private String nivPri;
	private String estSol;
	
	private String codSoli;
	private String dniSoli;
	private String nomSoli;
	private String apeSoli;
	private String emaSoli;
	private String telSoli;
	
	private Equipo equipo;
	private Byte canEqu;
	
	public Byte getCanEqu() {
		return canEqu;
	}

	public void setCanEqu(Byte canEqu) {
		this.canEqu = canEqu;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public String getCodSol() {
		return codSol;
	}
	public void setCodSol(String codSol) {
		this.codSol = codSol;
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
	
	public String getCodSoli() {
		return codSoli;
	}
	public void setCodSoli(String codSoli) {
		this.codSoli = codSoli;
	}
	public String getDniSoli() {
		return dniSoli;
	}
	public void setDniSoli(String dniSoli) {
		this.dniSoli = dniSoli;
	}
	public String getNomSoli() {
		return nomSoli;
	}
	public void setNomSoli(String nomSoli) {
		this.nomSoli = nomSoli;
	}
	public String getApeSoli() {
		return apeSoli;
	}
	public void setApeSoli(String apeSoli) {
		this.apeSoli = apeSoli;
	}
	public String getEmaSoli() {
		return emaSoli;
	}
	public void setEmaSoli(String emaSoli) {
		this.emaSoli = emaSoli;
	}
	public String getTelSoli() {
		return telSoli;
	}
	public void setTelSoli(String telSoli) {
		this.telSoli = telSoli;
	}
}
