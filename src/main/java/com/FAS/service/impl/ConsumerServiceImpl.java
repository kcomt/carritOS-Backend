package com.FAS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.Consumer;
import com.FAS.repository.ConsumerRepository;
import com.FAS.service.IConsumerService;

@Service
public class ConsumerServiceImpl implements IConsumerService{

	@Autowired
	private ConsumerRepository consumerRepository;
	
	
	@Transactional(readOnly=true)
	@Override
	public List<Consumer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return consumerRepository.findAll();
	}
	
	@Transactional
	@Override
	public Consumer save(Consumer t) throws Exception {
		// TODO Auto-generated method stub
		return consumerRepository.save(t);
	}

	@Transactional
	@Override
	public Consumer update(Consumer t) throws Exception {
		// TODO Auto-generated method stub
		return consumerRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Consumer> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return consumerRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		consumerRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		consumerRepository.deleteAll();
	}

}
