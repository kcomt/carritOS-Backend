package com.FAS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.FAS.entities.Review;
import com.FAS.repository.ReviewRepository;
import com.FAS.service.IReviewService;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional(readOnly=true)
	@Override
	public List<Review> findAll() throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.findAll();
	}

	@Transactional
	@Override
	public Review save(Review t) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.save(t);
	}

	@Transactional
	@Override
	public Review update(Review t) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.save(t);
	}

	@Transactional(readOnly=true)
	@Override
	public Optional<Review> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		reviewRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		reviewRepository.deleteAll();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Review> fetchByFoodTruckId(int id) throws Exception {
		// TODO Auto-generated method stub
		return reviewRepository.fetchByFoodTruckId(id);
	}

	
}
