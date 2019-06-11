package com.FAS.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.FoodTruck;
import com.FAS.repository.FoodTruckRepository;
import com.FAS.service.IFoodTruckService;

@Service
public class FoodTruckServiceImpl implements IFoodTruckService{

	@Autowired
	private FoodTruckRepository foodTruckRepository;
	
	@Transactional(readOnly= true)
	@Override
	public List<FoodTruck> findAll() throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.findAll();
	}

	@Transactional
	@Override
	public FoodTruck save(FoodTruck t) throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.save(t);
	}

	@Transactional
	@Override
	public FoodTruck update(FoodTruck t) throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<FoodTruck> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		foodTruckRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		foodTruckRepository.deleteAll();
	}

	@Transactional
	@Override
	public List<FoodTruck> fetchByName(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.fetchByName(nombre);
	}

	@Transactional
	@Override
	public List<FoodTruck> fetchAllFoodTruckOrderByRating() throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.fetchAllFoodTruckOrderByRating();
	}

	@Transactional
	@Override
	public List<FoodTruck> fetchByBuisnessOwnerId(int id) throws Exception {
		// TODO Auto-generated method stub
		return foodTruckRepository.fetchByBuisnessOwnerId(id);
	}

	
	
}
