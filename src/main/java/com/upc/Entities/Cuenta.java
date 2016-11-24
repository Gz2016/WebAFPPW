package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Cuenta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ccuenta;
	@Size(min=5, max=15)
	private String ntipocuenta;
	private double fondo;//CALCULO
	@ManyToOne
	@JoinColumn(name="cafiliado")
	private Afiliado cafiliado;
	public int getCcuenta() {
		return ccuenta;
	}
	public void setCcuenta(int ccuenta) {
		this.ccuenta = ccuenta;
	}
	public String getNtipocuenta() {
		return ntipocuenta;
	}
	public void setNtipocuenta(String ntipocuenta) {
		this.ntipocuenta = ntipocuenta;
	}
	public double getFondo() {
		return fondo;
	}
	public void setFondo(double fondo) {
		this.fondo = fondo;
	}
	public Afiliado getCafiliado() {
		return cafiliado;
	}
	public void setCafiliado(Afiliado cafiliado) {
		this.cafiliado = cafiliado;
	}
	
	
}
