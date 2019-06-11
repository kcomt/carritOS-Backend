package com.FAS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.Contract;
import com.FAS.repository.ContractRepository;
import com.FAS.service.IContractService;

@Service
public class ContractServiceImpl implements IContractService{

	@Autowired
	private ContractRepository contractRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Contract> findAll() throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.findAll();
	}

	@Transactional
	@Override
	public Contract save(Contract t) throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.save(t);
	}

	@Transactional
	@Override
	public Contract update(Contract t) throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Contract> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		contractRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		contractRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Contract> fetchByBuisnessOwnerIdState(int id, bool state) throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.fetchByBuisnessOwnerIdState(id, state);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Contract> fetchByConsumerIdState(int id, bool state) throws Exception {
		// TODO Auto-generated method stub
		return contractRepository.fetchByConsumerIdState(id, state);
	}

	
}
