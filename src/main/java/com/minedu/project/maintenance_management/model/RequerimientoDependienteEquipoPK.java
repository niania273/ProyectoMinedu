package com.minedu.project.maintenance_management.model;

import java.io.Serializable;

public class RequerimientoDependienteEquipoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codReq;
	private String codEqu;
	
	public RequerimientoDependienteEquipoPK() {
		// TODO Auto-generated constructor stub
	}

	public String getCodReq() {
		return codReq;
	}

	public void setCodReq(String codReq) {
		this.codReq = codReq;
	}

	public String getCodEqu() {
		return codEqu;
	}

	public void setCodEqu(String codEqu) {
		this.codEqu = codEqu;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj instanceof RequerimientoDependienteEquipoPK) {
        	RequerimientoDependienteEquipoPK spk = (RequerimientoDependienteEquipoPK) obj;
        	
        	return codReq.equals(spk.codReq) &&
        		   codEqu.equals(spk.codEqu);
        } else {
        	return false;
        }
    }

    @Override
    public int hashCode() {
        return new String(codReq + codEqu).hashCode();
    }
}
