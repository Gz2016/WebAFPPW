package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Operador {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int coperador;
	
	@Size(min=1, max= 30)
	private String nnombres;
	
	@Size(min=1, max= 30)
	private String napellidos;
	
	@Size(min=1, max= 10)
	private String dnacimiento;
	
	@Min(10000000)
	@Max(99999999)
	private int dni;

	public Operador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCoperador() {
		return coperador;
	}

	public void setCoperador(int coperador) {
		this.coperador = coperador;
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
