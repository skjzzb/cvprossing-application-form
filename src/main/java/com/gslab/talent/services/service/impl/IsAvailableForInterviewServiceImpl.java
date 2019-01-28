package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Isavailableforinterview;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.IsAvailableForInterviewRepository;
import com.gslab.talent.services.service.IsAvailableForInterviewService;

@Service
@Transactional
public class IsAvailableForInterviewServiceImpl implements IsAvailableForInterviewService {

	@Autowired
	IsAvailableForInterviewRepository isAvailableForInterviewRepository;
	
	@Override
	public void createIsAvailableForInterview(Isavailableforinterview isAvailableforinterview) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Isavailableforinterview> getIsAvailableForInterview() {
		// TODO Auto-generated method stub
		return (List<Isavailableforinterview>) isAvailableForInterviewRepository.findAll();
	}

	@Override
	public Isavailableforinterview findById(long id) {
		
		return isAvailableForInterviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Is Available For Interview", "id", id));
	}

	@Override
	public Isavailableforinterview update(Isavailableforinterview isAvailableforinterview, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteIsavailableforinterviewById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Isavailableforinterview updatePartially(Isavailableforinterview isAvailableforinterview, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
