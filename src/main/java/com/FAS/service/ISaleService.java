package com.FAS.service;

import java.util.List;

import com.FAS.entities.FoodTruck;
import com.FAS.entities.Sale;

public interface ISaleService extends CrudService<Sale>{

	List<FoodTruck> fetchByBuisnessOwnerId(int id) throws Exception;
}
