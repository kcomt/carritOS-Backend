package com.FAS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Consumer;
import com.FAS.entities.Seller;
import com.FAS.repository.BuisnessOwnerRepository;
import com.FAS.repository.ConsumerRepository;
import com.FAS.repository.SellerRepository;

@Service
public class UserDetail implements UserDetailsService {

	@Autowired
	private BuisnessOwnerRepository buisnessOwnerRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private SellerRepository sellerRepository;
	
	private Consumer findUserConsumer(String username) {

		Consumer user = consumerRepository.findByUsername(username);
		return user;

	}

	private BuisnessOwner findUserBuisnessOwner(String username) {

		BuisnessOwner user = buisnessOwnerRepository.findByUsername(username);
		return user;

	}
	
	private Seller findUserSeller(String username) {

		Seller seller = sellerRepository.findByUsername(username);
		return seller;

	}

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Consumer consumer = findUserConsumer(username);
		if (consumer != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			return new User(consumer.getUsername(), consumer.getPassword(), true, true, true, true, authorities);
		}
		BuisnessOwner buisnessOwner = findUserBuisnessOwner(username);
		if(buisnessOwner != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			return new User(buisnessOwner.getUsername(), buisnessOwner.getPassword(), true, true, true, true,authorities);
		}
		
		Seller seller = findUserSeller(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new User(seller.getUsername(), seller.getPassword(), true, true, true, true,authorities);
	}

}
