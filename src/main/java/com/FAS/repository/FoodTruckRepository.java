package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Integer> {
	
	@Query("select p from foodtruck p where p.name like %?1%")
	List<FoodTruck> fetchByName(String nombre);
	
	@Query("select r from foodtruck r order by r.buisnessOwnerId.rating desc")
	List<FoodTruck> fetchAllFoodTruckOrderByRating();
	
	@Query("select r from foodtruck r where r.buisnessOwnerId.id =?1")
	List<FoodTruck> fetchByBuisnessOwnerId(int id);
}
