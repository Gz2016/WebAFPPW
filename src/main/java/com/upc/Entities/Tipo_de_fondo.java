package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Tipo_de_fondo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ctipofondo;
	@Size(min=5,max=20)
	private String nfondo;
	@Size(min=5,max=45)
	private String tdescripcion;
	@Digits(integer=1,fraction=2)
	private double rentabilidad;
	@Size(min=4,max=20)
	private String nafp;
	public int getCtipofondo() {
		return ctipofondo;
	}
	public void setCtipofondo(int ctipofondo) {
		this.ctipofondo = ctipofondo;
	}
	public String getNfondo() {
		return nfondo;
	}
	public void setNfondo(String nfondo) {
		this.nfondo = nfondo;
	}
	public String getTdescripcion() {
		return tdescripcion;
	}
	public void setTdescripcion(String tdescripcion) {
		this.tdescripcion = tdescripcion;
	}
	public double getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	public String getNafp() {
		return nafp;
	}
	public void setNafp(String nafp) {
		this.nafp = nafp;
	}
	
	
	
}
