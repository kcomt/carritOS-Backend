package com.FAS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.SaleDetail;
import com.FAS.repository.SaleDetailRepository;
import com.FAS.service.ISaleDetailService;

@Service
public class SaleDetailServiceImpl implements ISaleDetailService{

	@Autowired
	private SaleDetailRepository saleDetailRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<SaleDetail> findAll() throws Exception {
		// TODO Auto-generated method stub
		return saleDetailRepository.findAll();
	}

	@Transactional
	@Override
	public SaleDetail save(SaleDetail t) throws Exception {
		// TODO Auto-generated method stub
		return saleDetailRepository.save(t);
	}

	@Transactional
	@Override
	public SaleDetail update(SaleDetail t) throws Exception {
		// TODO Auto-generated method stub
		return saleDetailRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<SaleDetail> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return saleDetailRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		saleDetailRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		saleDetailRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<SaleDetail> fetchBySaleId(int id) throws Exception {
		// TODO Auto-generated method stub
		return saleDetailRepository.fetchBySaleId(id);
	}
	
}
