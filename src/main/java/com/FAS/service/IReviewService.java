package com.FAS.service;

import java.util.List;

import com.FAS.entities.Review;

public interface IReviewService extends CrudService<Review>{
	List<Review> fetchByFoodTruckId(int id)throws Exception;
}
