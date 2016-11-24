package com.upc.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

@Entity
public class Interesxmora {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cintxmora;
	@Max(11)
	private int qdias;
	@Digits(integer=10,fraction=2)
	private double montointeres;
	@Digits(integer=1,fraction=2)
	private double qporcentajemora;
	public int getCintxmora() {
		return cintxmora;
	}
	public void setCintxmora(int cintxmora) {
		this.cintxmora = cintxmora;
	}
	public int getQdias() {
		return qdias;
	}
	public void setQdias(int qdias) {
		this.qdias = qdias;
	}
	public double getMontointeres() {
		return montointeres;
	}
	public void setMontointeres(double montointeres) {
		this.montointeres = montointeres;
	}
	public double getQporcentajemora() {
		return qporcentajemora;
	}
	public void setQporcentajemora(double qporcentajemora) {
		this.qporcentajemora = qporcentajemora;
	}
	
	
}
