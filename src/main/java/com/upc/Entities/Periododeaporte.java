package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "periododeaporte")
public class Periododeaporte {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int cperiodoaporte;
@Size(min=10,max=10)
private String dinicio;
@Size(min=10,max=10)
private String dfin;
@Size(max=45)
private String tdescripcion;
@Size(min=1,max=15)
private String ntipoperiodo;//MENSUAL, CADA 35 DIAS,ETC
@Size(min=2,max=5)
private String fpagoatiempo;
@Size(min=2,max=5)// SI o NO
private String fpago;
@ManyToOne
@JoinColumn(name="cafiliado")
private Afiliado cafiliado;

public Periododeaporte(){
	super();
}

public int getCperiodoaporte() {
	return cperiodoaporte;
}
public void setCperiodoaporte(int cperiodoaporte) {
	this.cperiodoaporte = cperiodoaporte;
}
public String getDinicio() {
	return dinicio;
}
public void setDinicio(String dinicio) {
	this.dinicio = dinicio;
}
public String getDfin() {
	return dfin;
}
public void setDfin(String dfin) {
	this.dfin = dfin;
}
public String getTdescripcion() {
	return tdescripcion;
}
public void setTdescripcion(String tdescripcion) {
	this.tdescripcion = tdescripcion;
}
public String getNtipoperiodo() {
	return ntipoperiodo;
}
public void setNtipoperiodo(String ntipoperiodo) {
	this.ntipoperiodo = ntipoperiodo;
}
public String getFpagoatiempo() {
	return fpagoatiempo;
}
public void setFpagoatiempo(String fpagoatiempo) {
	this.fpagoatiempo = fpagoatiempo;
}
public String getFpago() {
	return fpago;
}
public void setFpago(String fpago) {
	this.fpago = fpago;
}
public Afiliado getCafiliado() {
	return cafiliado;
}
public void setCafiliado(Afiliado cafiliado) {
	this.cafiliado = cafiliado;
}

}
