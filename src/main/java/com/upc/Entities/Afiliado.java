package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Afiliado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cafiliado;
	@Size(min=2,max=4)
	private String fdependiente; //SI cuando es dependiente y NO cuando es independiente
	@Digits(integer=10,fraction=2)
	private double sueldo;
	@Size(min=5, max=30)
	private String nnombres;
	@Size(min=5, max=30)
	private String napellidos;
	@Size(min=10, max=10)
	private String dnacimiento;//FORMATO (11-11-1111) PARA PODER FILTRAR POR FECHA
	@Min(10000000)
	@Max(99999999)
	private int dni;
	
	@ManyToOne
	@JoinColumn(name="crep_empresa")
	private rep_empresa crep_empresa;
	
	@OneToOne
	@JoinColumn(name="ctipofondo")
	private Tipo_de_fondo ctipofondo;
	public int getCafiliado() {
		return cafiliado;
	}
	public void setCafiliado(int cafiliado) {
		this.cafiliado = cafiliado;
	}
	public String getFdependiente() {
		return fdependiente;
	}
	public void setFdependiente(String fdependiente) {
		this.fdependiente = fdependiente;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
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
	public rep_empresa getCrep_empresa() {
		return crep_empresa;
	}
	public void setCrep_empresa(rep_empresa crep_empresa) {
		this.crep_empresa = crep_empresa;
	}
	public Tipo_de_fondo getCtipofondo() {
		return ctipofondo;
	}
	public void setCtipofondo(Tipo_de_fondo ctipofondo) {
		this.ctipofondo = ctipofondo;
	}
	
}
