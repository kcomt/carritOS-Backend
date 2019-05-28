package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Integer> {
	
	@Query("select f from foodtruck f where f.name like %?1%")
	List<FoodTruck> fetchByName(String nombre);
	
	@Query("select f from foodtruck f order by f.buisnessOwnerId.rating desc")
	List<FoodTruck> fetchAllFoodTruckOrderByRating();
	
	@Query("select f from foodtruck f inner join f.buisnessOwnerId b where b.id =?1")
	List<FoodTruck> fetchByBuisnessOwnerId(int id);
}
