package com.minedu.project.maintenance_management.model;

import java.io.Serializable;

public class SolicitudEquipoIncidentePK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codSol;
	private String codEqu;
	private String codInc;
	
	public SolicitudEquipoIncidentePK() {
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

	public String getCodInc() {
		return codInc;
	}

	public void setCodInc(String codInc) {
		this.codInc = codInc;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof SolicitudEquipoIncidentePK) {
        	SolicitudEquipoIncidentePK spk = (SolicitudEquipoIncidentePK) obj;
        	
        	return codSol.equals(spk.codSol) &&
        		   codEqu.equals(spk.codEqu) &&
        		   codInc.equals(spk.codInc);
        } else {
        	return false;
        }
    }

    @Override
    public int hashCode() {
        return new String(codSol + codEqu + codInc).hashCode();
    }
}
