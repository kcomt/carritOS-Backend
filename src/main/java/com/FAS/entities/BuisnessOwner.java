package com.FAS.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "buisness_owners"/*, uniqueConstraints = {
		@UniqueConstraint(columnNames = {"username"} ),
		@UniqueConstraint(columnNames = {"dni"} ),
		@UniqueConstraint(columnNames = {"buisness_name"} )
}*/)
public class BuisnessOwner {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NaturalId
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;
	
	@Size(min = 3, message = "Username must be atleast 3 charecters in length")
	@Column(name = "username", nullable = false, length = 50)
	private String username;
	
	@NotBlank
	@Size(min = 3, message = "Password must be atleast 3 charecters in length")
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@NotBlank
	@Size(min = 4, message = "Username must be atleast 4 charecters in length")
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@NotBlank
	@Size(min = 4, message = "Username must be atleast 4 charecters in length")
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@NotBlank
	@Size(min = 8, message = "DNI must be 8 charecters in length")
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@NotBlank
	@Size(min = 2, message = "Buisness Name must be 2 charecters in length")
	@Column(name = "buisness_name", nullable = false, length = 150)
	private String buisnessName;
	
	@Column(name = "rating", nullable = false)
	private int rating;

	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

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
