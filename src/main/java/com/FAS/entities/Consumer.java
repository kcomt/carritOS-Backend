package com.FAS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "consumer")
public class Consumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, message = "Username must be atleast 3 charecters in length")
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	
	@Size(min = 3, message = "Password must be atleast 3 charecters in length")
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Size(min = 4, message = "Username must be atleast 4 charecters in length")
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	
	@Size(min = 2, message = "Email must be 5 charecters in length")
	@Column(name = "email", nullable = false, length = 100)
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
