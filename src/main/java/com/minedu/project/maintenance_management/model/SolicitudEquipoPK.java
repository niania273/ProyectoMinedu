package com.minedu.project.maintenance_management.model;

import java.io.Serializable;

public class SolicitudEquipoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codSol;
	private String codEqu;
	
	public SolicitudEquipoPK() {
		// TODO Auto-generated constructor stub
	}

	public String getCodSol() {
		return codSol;
	}

	public void setCodSol(String codSol) {
		this.codSol = codSol;
	}

	public String getCodEqu() {
		return codEqu;
	}

	public void setCodEqu(String codEqu) {
		this.codEqu = codEqu;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (obj instanceof SolicitudEquipoPK) {
	        	SolicitudEquipoPK spk = (SolicitudEquipoPK) obj;
	        	
	        	return codSol.equals(spk.codSol) && codEqu.equals(spk.codEqu);
	        } else {
	        	return false;
	        }
	    }

	    @Override
	    public int hashCode() {
	        return new String(codSol + codEqu).hashCode();
	    }
}
