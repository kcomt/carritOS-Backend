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
@Table(name = "sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "total", nullable = false)
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller sellerId;

	@Size(min = 1, message = "Summary must be atleast 5 charecters in length")
	@Column(name = "summary", nullable = true, length = 250)
	private String summary;

	@Size(min = 4, message = "Date must be atleast 4 charecters in length")
	@Column(name = "date", nullable = false, length = 50)
	private String date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Seller getSellerId() {
		return sellerId;
	}

	public void setSellerId(Seller sellerId) {
		this.sellerId = sellerId;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
