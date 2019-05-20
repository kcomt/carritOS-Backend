package com.FAS.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 4, message = "Location must be atleast 4 charecters in length")
	@Column(name = "location", nullable = false, length = 100)
	private String location;
	
	@Size(min = 4, message = "Date must be atleast 4 charecters in length")
	@Column(name = "date", nullable = false, length = 10)
	private String date;
	
	@Size(min = 4, message = "Especification must be atleast 4 charecters in length")
	@Column(name = "especification", nullable = false, length = 250)
	private String especification;
	
	@Column(name = "accepted", nullable = false)
	private boolean accepted;
	
	@ManyToOne
	@JoinColumn(name = "buisness_owner_id", nullable = false)
	private BuisnessOwner buisnessOwnerId;
	
	@ManyToOne
	@JoinColumn(name = "consumerid", nullable = false)
	private Consumer consumerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEspecification() {
		return especification;
	}

	public void setEspecification(String especification) {
		this.especification = especification;
	}

	public BuisnessOwner getBuisnessOwnerId() {
		return buisnessOwnerId;
	}

	public void setBuisnessOwnerId(BuisnessOwner buisnessOwnerId) {
		this.buisnessOwnerId = buisnessOwnerId;
	}

	public Consumer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Consumer consumerId) {
		this.consumerId = consumerId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
		
}
