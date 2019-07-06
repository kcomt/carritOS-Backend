package com.FAS.service;

import java.util.List;

import com.FAS.entities.Seller;

public interface ISellerService extends CrudService<Seller>{
	List<Seller> fetchByBuisnessOwnerId(int id) throws Exception;
	Seller findByUsername(String seller);
}
