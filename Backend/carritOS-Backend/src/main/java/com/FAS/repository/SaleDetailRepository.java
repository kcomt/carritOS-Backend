package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.SaleDetail;
@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {
	@Query("select r from SaleDetail r where r.saleId.id =?1")
	List<SaleDetail> fetchBySaleId(int id);

}
