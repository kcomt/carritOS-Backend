package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

	@Query("select c from Contract c  inner join  c.buisnessOwnerId b where b.id =?1")
	List<Contract> fetchByBuisnessOwnerIdState(int id);
	
	@Query("select c from Contract c  inner join  c.consumerId con where con.id =?1")
	List<Contract> fetchByConsumerIdState(int id);
}