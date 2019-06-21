package com.FAS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "buisness_owners")
public class BuisnessOwner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, message = "Username must be atleast 3 charecters in length")
	@Column(name = "username", nullable = false, length = 15)
	private String username;
	
	@Size(min = 3, message = "Password must be atleast 3 charecters in length")
	@Column(name = "password", nullable = false, length = 15)
	private String password;
	
	@Size(min = 4, message = "Username must be atleast 4 charecters in length")
	@Column(name = "name", nullable = false, length = 20)
	private String name;
	
	@Size(min = 8, message = "DNI must be 8 charecters in length")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Size(min = 2, message = "Buisness Name must be 2 charecters in length")
	@Column(name = "buisness_name", nullable = false, length = 15)
	private String buisnessName;
	
	@Column(name = "rating", nullable = false)
	private int rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdni() {
		return dni;
	}

	public void setdni(String dNI) {
		dni = dNI;
	}

	public String getBuisnessName() {
		return buisnessName;
	}

	public void setBuisnessName(String buisnessName) {
		this.buisnessName = buisnessName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
