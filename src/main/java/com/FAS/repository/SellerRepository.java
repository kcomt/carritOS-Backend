package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.FAS.entities.Seller;

public interface SellerRepository {

	@Query("select r from seller r where r.buisnessOwnerId.id =?1")
	List<Seller> fetchByBuisnessOwnerId(int id);
}
