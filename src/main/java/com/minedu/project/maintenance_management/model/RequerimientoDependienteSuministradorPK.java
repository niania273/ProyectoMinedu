package com.minedu.project.maintenance_management.model;

import java.io.Serializable;

public class RequerimientoDependienteSuministradorPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codReq;
	private String codSum;
	
	public RequerimientoDependienteSuministradorPK() {
		// TODO Auto-generated constructor stub
	}

	public String getCodReq() {
		return codReq;
	}

	public void setCodReq(String codReq) {
		this.codReq = codReq;
	}

	public String getCodSum() {
		return codSum;
	}

	public void setCodSum(String codSum) {
		this.codSum = codSum;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof RequerimientoDependienteSuministradorPK) {
        	RequerimientoDependienteSuministradorPK spk = (RequerimientoDependienteSuministradorPK) obj;
        	
        	return codReq.equals(spk.codReq) &&
        		   codSum.equals(spk.codSum);
        } else {
        	return false;
        }
    }

    @Override
    public int hashCode() {
        return new String(codReq + codSum).hashCode();
    }
}
