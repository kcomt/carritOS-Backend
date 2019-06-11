package com.FAS.service;

import java.util.List;
import com.FAS.entities.Contract;

public interface IContractService extends CrudService<Contract>{

	List<Contract> fetchByBuisnessOwnerIdState(int id, boolean state)throws Exception;
	List<Contract> fetchByConsumerIdState(int id, boolean state)throws Exception;
}
