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
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.BuisnessOwner;
import com.FAS.repository.BuisnessOwnerRepository;
import com.FAS.service.IBuisnessOwnerService;

@Service
public class BuisnessOwnerServiceImpl implements IBuisnessOwnerService,UserDetailsService{

	@Autowired
	private BuisnessOwnerRepository buisnessOwnerRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<BuisnessOwner> findAll() throws Exception {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.findAll();
	}

	@Transactional
	@Override
	public BuisnessOwner save(BuisnessOwner t) throws Exception {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.save(t);
	}

	@Transactional
	@Override
	public BuisnessOwner update(BuisnessOwner t) throws Exception {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<BuisnessOwner> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		buisnessOwnerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		buisnessOwnerRepository.deleteAll();
	}

	@Transactional
	@Override
	public Boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.existsByUsername(username);
	}

	@Transactional
	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return buisnessOwnerRepository.existsByEmail(email);
	}


	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		BuisnessOwner user = buisnessOwnerRepository.findByUsername(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	@Transactional(readOnly=true)
	@Override
	public BuisnessOwner findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
