package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class solicitud_retiro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int csolicitud;
	
	@Size(min=1,max=50)
	private String tdetalles;
	
	@Size(min=1,max=15)
	private String nestado;
	
	@ManyToOne
	@JoinColumn(name="cafiliado")
	private Afiliado afiliado;
	
	@ManyToOne
	@JoinColumn(name="coperador")
	private Operador operador;

	public solicitud_retiro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCsolicitud() {
		return csolicitud;
	}

	public void setCsolicitud(int csolicitud) {
		this.csolicitud = csolicitud;
	}

	public String getTdetalles() {
		return tdetalles;
	}

	public void setTdetalles(String tdetalles) {
		this.tdetalles = tdetalles;
	}

	public String getNestado() {
		return nestado;
	}

	public void setNestado(String nestado) {
		this.nestado = nestado;
	}

	public Afiliado getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	
	
}
