package com.FAS.service;

import com.FAS.entities.Consumer;

public interface IConsumerService extends CrudService<Consumer>{
	public Consumer findByUsername(String username);
	
}
