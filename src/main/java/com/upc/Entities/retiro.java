package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;


@Entity
public class retiro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cretiro;
	
	@Digits(integer=10, fraction=2)
	private double montoretiro;
	
	@Size(min=1, max= 10)
	private String dretiro;
	
	@Size(min=1,max =15)
	private String ntiporetiro;
	
	@ManyToOne
	@JoinColumn(name="ccuenta")
	private Cuenta cuenta;
	
	@OneToOne
	@JoinColumn(name="csolicitud")
	private solicitud_retiro solicitudretiro;

	public retiro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCretiro() {
		return cretiro;
	}

	public void setCretiro(int cretiro) {
		this.cretiro = cretiro;
	}

	public double getMontoretiro() {
		return montoretiro;
	}

	public void setMontoretiro(double montoretiro) {
		this.montoretiro = montoretiro;
	}

	public String getDretiro() {
		return dretiro;
	}

	public void setDretiro(String dretiro) {
		this.dretiro = dretiro;
	}

	public String getNtiporetiro() {
		return ntiporetiro;
	}

	public void setNtiporetiro(String ntiporetiro) {
		this.ntiporetiro = ntiporetiro;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public solicitud_retiro getSolicitudretiro() {
		return solicitudretiro;
	}

	public void setSolicitudretiro(solicitud_retiro solicitudretiro) {
		this.solicitudretiro = solicitudretiro;
	}
	
	
}
