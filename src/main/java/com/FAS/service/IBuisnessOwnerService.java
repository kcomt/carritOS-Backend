package com.FAS.service;

import java.util.Optional;

import com.FAS.entities.BuisnessOwner;

public interface IBuisnessOwnerService extends CrudService<BuisnessOwner> {

	Optional<BuisnessOwner> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
