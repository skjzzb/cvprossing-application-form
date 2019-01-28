package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Modeofinterview;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.ModeOfInterviewRepository;
import com.gslab.talent.services.service.ModeOfInterviewService;

@Service
@Transactional
public class ModeOfInterviewServiceImpl implements ModeOfInterviewService {

	@Autowired
	ModeOfInterviewRepository modeOfInterviewRepository;
	
	@Override
	public void createModeofinterview(Modeofinterview Modeofinterview) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Modeofinterview> getModeofinterview() {
		// TODO Auto-generated method stub
		return (List<Modeofinterview>) modeOfInterviewRepository.findAll();
	}

	@Override
	public Modeofinterview findById(long id) {
		
		return modeOfInterviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mode Of Interview", "id", id));
	}

	@Override
	public Modeofinterview update(Modeofinterview Modeofinterview, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModeofinterviewById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Modeofinterview updatePartially(Modeofinterview Modeofinterview, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
