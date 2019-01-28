package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Position;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.PositionRepository;
import com.gslab.talent.services.service.PositionService;
@Service
@Transactional
public class PositionServiceImpl implements PositionService {

	@Autowired
	PositionRepository positionRepository;
	
	@Override
	public void createPosition(Position Position) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Position> getPosition() {
		// TODO Auto-generated method stub
		return (List<Position>) positionRepository.findAll();
	}

	@Override
	public Position findById(long id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Position", "id", id));
	}

	@Override
	public Position update(Position Position, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePositionById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Position updatePartially(Position Position, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
