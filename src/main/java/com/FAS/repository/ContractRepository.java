package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

	@Query("select c from Contract c where c.buisnessOwnerId.id =?1 and c.accepted = ?2")
	List<Contract> fetchByBuisnessOwnerIdState(int id, boolean state);
	
	@Query("select c from Contract c where c.consumerId.id =?1 and c.accepted = ?2")
	List<Contract> fetchByConsumerIdState(int id, boolean state);
}
