package com.FAS.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	
	private String name;
	
	private Double price;
	
	@OneToMany
	private int menu_id;
	
	@OneToMany
	private int sale_report_detail_id;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getSale_report_detail_id() {
		return sale_report_detail_id;
	}

	public void setSale_report_detail_id(int sale_report_detail_id) {
		this.sale_report_detail_id = sale_report_detail_id;
	}
	
	
	
}
