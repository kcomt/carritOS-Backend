package com.FAS.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.Seller;
import com.FAS.repository.SaleRepository;
import com.FAS.repository.SellerRepository;
import com.FAS.service.ISellerService;

@Service
public class SellerServiceImpl implements ISellerService{

	@Autowired
	private SellerRepository sellerRepository;
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Seller> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sellerRepository.findAll();
	}

	@Override
	public Seller save(Seller t) throws Exception {
		// TODO Auto-generated method stub
		return sellerRepository.save(t);
	}

	@Override
	public Seller update(Seller t) throws Exception {
		// TODO Auto-generated method stub
		return sellerRepository.save(t);
	}

	@Override
	public Optional<Seller> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		saleRepository.deleteInBulk(id);
		sellerRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Seller> fetchByBuisnessOwnerId(int id) throws Exception {
		// TODO Auto-generated method stub
		return sellerRepository.fetchByBuisnessOwnerId(id);
	}



	@Transactional(readOnly = true)
	@Override
	public Seller findByUsername(String seller) {
		// TODO Auto-generated method stub
		return sellerRepository.findByUsername(seller);
	}
	
}
