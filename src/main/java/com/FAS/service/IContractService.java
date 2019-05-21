package com.FAS.service;

import java.util.List;
import com.FAS.entities.Contract;

public interface IContractService extends CrudService<Contract>{

	List<Contract> fetchByBuisnessOwnerIdState(int id)throws Exception;
	List<Contract> fetchByConsumerIdState(int id)throws Exception;
}
