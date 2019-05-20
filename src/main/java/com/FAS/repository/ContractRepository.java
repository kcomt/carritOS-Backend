package com.FAS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

	@Query("select r from contract r where r.buisnessOwnerId.id =?1 and r.accepted =?2")
	List<Contract> fetchByBuisnessOwnerIdState(int id);
	
	@Query("select r from contract r where r.consumerId.id =?1 and r.accepted =?2")
	List<Contract> fetchByConsumerIdState(int id);
}
