package com.FAS.service;

import java.util.List;
import com.FAS.entities.FoodTruck;

public interface IFoodTruckService extends CrudService<FoodTruck>{

	List<FoodTruck> fetchByName(String nombre)throws Exception;
	List<FoodTruck> fetchAllFoodTruckOrderByRating()throws Exception;
	List<FoodTruck> fetchByBuisnessOwnerId(int id)throws Exception;
}
