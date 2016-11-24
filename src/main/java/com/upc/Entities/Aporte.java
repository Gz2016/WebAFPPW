package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Aporte {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int caporte;
private double montoaporte;//CALCULO
@Size(min=10,max=10)
private String daporte;//FECHA EN LA QUE SE CUMPLIO CON EL APORTE
@Size(min=10,max=11)//VOLUNTARIO O OBLIGATORIO
private String naporte;
@ManyToOne
@JoinColumn(name="ccuenta")
private Cuenta ccuenta;
@OneToOne
@JoinColumn(name="cintxmora")
private Interesxmora cintxmora;

public int getCaporte() {
	return caporte;
}
public void setCaporte(int caporte) {
	this.caporte = caporte;
}
public double getMontoaporte() {
	return montoaporte;
}
public void setMontoaporte(double montoaporte) {
	this.montoaporte = montoaporte;
}
public String getDaporte() {
	return daporte;
}
public void setDaporte(String daporte) {
	this.daporte = daporte;
}
public String getNaporte() {
	return naporte;
}
public void setNaporte(String naporte) {
	this.naporte = naporte;
}
public Cuenta getCcuenta() {
	return ccuenta;
}
public void setCcuenta(Cuenta ccuenta) {
	this.ccuenta = ccuenta;
}
public Interesxmora getCintxmora() {
	return cintxmora;
}
public void setCintxmora(Interesxmora cintxmora) {
	this.cintxmora = cintxmora;
}


}
