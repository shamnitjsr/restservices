package com.nitjsr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitjsr.entity.Tourist;
import com.nitjsr.repository.ITouristRepo;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService{
	
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		
		int idVal =  touristRepo.save(tourist).getTid();
		return "Tourist is registered having the id value::"+idVal;
		
	}

}
