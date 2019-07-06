package com.FAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FAS.entities.BuisnessOwner;

@Repository
public interface BuisnessOwnerRepository extends JpaRepository<BuisnessOwner, Integer> {
	BuisnessOwner findByUsername(String username);
	
}
