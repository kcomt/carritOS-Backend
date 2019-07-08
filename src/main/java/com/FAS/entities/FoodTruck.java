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
	
	@Size(min = 1, message = "Username must be atleast 1 charecters in length")
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Size(min = 1, message = "Phonenumber must be atleast 1 charecters in length")
	@Column(name = "phoneNumber", nullable = false, length = 50)
	private String phoneNumber;
	
	@Size(min = 1, message = "FoodType must be atleast 1 charecters in length")
	@Column(name = "foodType", nullable = false, length = 50)
	private String foodType;
	
	@Size(min = 1, message = "Cost must be atleast 1 charecters in length")
	@Column(name = "cost", nullable = false, length = 50)
	private String cost;

	@Size(min = 1, message = "FoodType must be atleast 1 charecters in length")
	@Column(name = "url", nullable = false, length = 1000)
	private String url;
	
	@Column(name = "longitude", nullable = false)
	private double longitude;
	
	@Column(name = "latitude", nullable = false)
	private double latitude;
	
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

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
