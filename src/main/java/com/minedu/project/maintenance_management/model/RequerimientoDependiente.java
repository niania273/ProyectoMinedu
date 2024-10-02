package com.minedu.project.maintenance_management.model;

import jakarta.persistence.*;

@Entity
@Table (name = "REQUERIMIENTO_DEPENDIENTE")
public class RequerimientoDependiente extends Requerimiento{

	@Column (name = "MON_PRE", nullable = true)
	private String nomMod;
	
	@Column (name = "ALC_REQ", length = 150, nullable = false)
	private String alcReq;
	
	@Column (name = "OBJ_SER", length = 100, nullable = true)
	private String objSer;

	public String getNomMod() {
		return nomMod;
	}

	public void setNomMod(String nomMod) {
		this.nomMod = nomMod;
	}

	public String getAlcReq() {
		return alcReq;
	}

	public void setAlcReq(String alcReq) {
		this.alcReq = alcReq;
	}

	public String getObjSer() {
		return objSer;
	}

	public void setObjSer(String objSer) {
		this.objSer = objSer;
	}
}
