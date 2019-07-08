package com.FAS.service;


import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Consumer;

public interface IBuisnessOwnerService extends CrudService<BuisnessOwner> {
	public BuisnessOwner findByUsername(String username);
}
