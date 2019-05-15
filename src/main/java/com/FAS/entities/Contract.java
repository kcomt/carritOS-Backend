package com.FAS.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contrato_id;
	
	private String location;
	
	private Date fecha_inicio;
	
	private Date fecha_fin;
	
	private String especification;
	
	@OneToMany
	private int business_id;
	
	@OneToMany
	private int consumer_id;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getEspecification() {
		return especification;
	}

	public void setEspecification(String especification) {
		this.especification = especification;
	}

	public int getBusiness_id() {
		return business_id;
	}

	public int getContrato_id() {
		return contrato_id;
	}

	public void setContrato_id(int contrato_id) {
		this.contrato_id = contrato_id;
	}

	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}

	public int getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(int consumer_id) {
		this.consumer_id = consumer_id;
	}
	

}
