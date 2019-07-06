package com.FAS.service;


import com.FAS.entities.BuisnessOwner;

public interface IBuisnessOwnerService extends CrudService<BuisnessOwner> {
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	BuisnessOwner findByUsername(String username);
}
