package com.FAS.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.Seller;
import com.FAS.repository.SellerRepository;
import com.FAS.service.ISellerService;

@Service
public class SellerServiceImpl implements ISellerService{

	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
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
<<<<<<< HEAD

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Seller user = sellerRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	@Transactional(readOnly = true)
	@Override
	public Seller findByUsername(String seller) {
		// TODO Auto-generated method stub
		return null;
	}

=======
>>>>>>> c32cb4e436f0b288a927a96c79d22cd29dafda65
	
}
