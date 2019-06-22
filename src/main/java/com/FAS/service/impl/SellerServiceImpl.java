package com.FAS.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Seller;
import com.FAS.repository.SellerRepository;
import com.FAS.service.ISellerService;

@Service
public class SellerServiceImpl implements ISellerService, UserDetailsService{

	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public List<Seller> findAll() throws Exception {
		// TODO Auto-generated method stub
		return sellerRepository.findAll();
	}

	@Override
	public Seller save(Seller t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seller update(Seller t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Seller> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Seller> fetchByBuisnessOwnerId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Seller user = sellerRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	
}
