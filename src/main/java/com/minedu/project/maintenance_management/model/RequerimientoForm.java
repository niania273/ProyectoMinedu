package com.minedu.project.maintenance_management.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;

public class RequerimientoForm {
	
	private String codReq;
	
	private String codSol;
	
	private String codSum;
	
	private String titReq;
	
	private String desReq;
	
	private String plaEjeReq;
	
	private double preReq;
	
	private Date fecLim;
	
	private String estReq;
	
	private Date fecCre;
	
	private Date fecAct;
	
}
