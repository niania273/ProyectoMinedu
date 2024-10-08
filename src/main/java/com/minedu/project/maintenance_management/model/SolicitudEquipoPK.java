package com.minedu.project.maintenance_management.model;

import java.io.Serializable;

public class SolicitudEquipoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String solicitud;
	private String equipo;
	
	 public SolicitudEquipoPK(String solicitud, String equipo) {
		this.solicitud = solicitud;
		this.equipo = equipo;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	@Override
	    public boolean equals(Object obj) {
	        if (obj instanceof SolicitudEquipoPK) {
	        	SolicitudEquipoPK spk = (SolicitudEquipoPK) obj;
	        	
	        	return solicitud.equals(spk.solicitud) && equipo.equals(spk.equipo);
	        } else {
	        	return false;
	        }
	    }

	    @Override
	    public int hashCode() {
	        return new String(solicitud + equipo).hashCode();
	    }
}
