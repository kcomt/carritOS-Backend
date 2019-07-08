package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.FAS.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

	@Query("select r from Sale r where r.sellerId.buisnessOwnerId.id =?1")
	List<Sale> fetchByBuisnessOwnerId(int id);
	
	@Modifying
	@Query("delete from Sale r where r.sellerId.id = ?1")
	void deleteInBulk(int id);
	
	@Query("delete from Sale r where r.foodTruckId.id = ?1")
	void deleteInBulkFT(int id);
}
