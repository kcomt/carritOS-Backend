package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Integer> {
	
	@Query("select f from FoodTruck f where f.name like %?1%")
	List<FoodTruck> fetchByName(String nombre);
	
	@Query("select f from FoodTruck f order by f.buisnessOwnerId.rating desc")
	List<FoodTruck> fetchAllFoodTruckOrderByRating();
	
	@Query("select f from FoodTruck f where f.id =?1")
	List<FoodTruck> fetchByBuisnessOwnerId(int id);
}
