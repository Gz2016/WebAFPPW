package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class rep_empresa 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int crep_empresa;
	@Min(10000000)
	@Max(99999999)
	private int ruc;
	@Size(min=5,max=45)
	private String nempresa;
	@Size(min=5,max=45)
	private String nnombres;
	@Size(min=5,max=45)
	private String napellidos;
	@Size(min=5,max=45)
	private String dnacimiento;
	@Min(10000000)
	@Max(99999999)
	private int dni;
	
	public int getCrep_empresa() {
		return crep_empresa;
	}
	public void setCrep_empresa(int crep_empresa) {
		this.crep_empresa = crep_empresa;
	}
	public int getRuc() {
		return ruc;
	}
	public void setRuc(int ruc) {
		this.ruc = ruc;
	}
	public String getNempresa() {
		return nempresa;
	}
	public void setNempresa(String nempresa) {
		this.nempresa = nempresa;
	}
	public String getNnombres() {
		return nnombres;
	}
	public void setNnombres(String nnombres) {
		this.nnombres = nnombres;
	}
	public String getNapellidos() {
		return napellidos;
	}
	public void setNapellidos(String napellidos) {
		this.napellidos = napellidos;
	}
	public String getDnacimiento() {
		return dnacimiento;
	}
	public void setDnacimiento(String dnacimiento) {
		this.dnacimiento = dnacimiento;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
}
