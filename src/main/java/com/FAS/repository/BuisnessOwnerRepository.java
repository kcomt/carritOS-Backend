package com.FAS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FAS.entities.BuisnessOwner;

@Repository
public interface BuisnessOwnerRepository extends JpaRepository<BuisnessOwner, Integer> {
	 Optional<BuisnessOwner> findByUsername(String username);
	 Boolean existsByUsername(String username);
	 Boolean existsByEmail(String email);
}
