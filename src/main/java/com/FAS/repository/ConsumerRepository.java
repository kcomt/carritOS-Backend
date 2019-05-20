package com.FAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FAS.entities.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {
 
}
