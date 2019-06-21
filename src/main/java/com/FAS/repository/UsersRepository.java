package com.FAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByName(String name);
	
}
