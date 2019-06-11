package com.FAS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "foodtruck")
public class FoodTruck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 4, message = "Username must be atleast 4 charecters in length")
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@Column(name = "longitude", nullable = false)
	private float longitude;
	
	@Column(name = "latitude", nullable = false)
	private float latitude;
	
	@ManyToOne
	@JoinColumn(name = "buisness_owner_id", nullable = false)
	private BuisnessOwner buisnessOwnerId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public BuisnessOwner getBuisnessOwnerId() {
		return buisnessOwnerId;
	}

	public void setBuisnessOwnerId(BuisnessOwner buisnessOwnerId) {
		this.buisnessOwnerId = buisnessOwnerId;
	}
	
	
}
