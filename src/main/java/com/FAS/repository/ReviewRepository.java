package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query("select r from Review r where r.foodTruckId.id =?1")
	List<Review> fetchByFoodTruckId(int id);
	
	@Modifying
	@Query("delete from Review r where r.foodTruckId.id = ?1")
	void deleteInBulk(int id);
}
