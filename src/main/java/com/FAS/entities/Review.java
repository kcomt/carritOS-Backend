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
@Table(name="review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_id;
	
	@Column(name = "qualification", nullable = true)
	private int qualification;
	
	@Size(min = 5, message = "Comment must be atleast 5 charecters in length")
	@Column(name = "comment", nullable = true, length = 250)
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "foodTruck_id", nullable = false)
	private FoodTruck foodTruckId;
	
	@ManyToOne
	@JoinColumn(name = "consumer_id", nullable = false)
	private Consumer consumerId;

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getQualification() {
		return qualification;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public FoodTruck getFoodTruckId() {
		return foodTruckId;
	}

	public void setFoodTruckId(FoodTruck foodTruckId) {
		this.foodTruckId = foodTruckId;
	}

	public Consumer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Consumer consumerId) {
		this.consumerId = consumerId;
	}

}
