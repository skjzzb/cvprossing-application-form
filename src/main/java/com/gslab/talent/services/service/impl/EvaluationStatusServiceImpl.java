package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Evaluationstatus;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.EvaluationStatusRepository;
import com.gslab.talent.services.service.EvaluationStatusService;

@Service
@Transactional
public class EvaluationStatusServiceImpl implements EvaluationStatusService {

	@Autowired
	EvaluationStatusRepository evaluationStatusRepository;
	
	@Override
	public void createEvaluationstatus(Evaluationstatus Evaluationstatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Evaluationstatus> getEvaluationstatus() {
		// TODO Auto-generated method stub
		return (List<Evaluationstatus>) evaluationStatusRepository.findAll();
	}

	@Override
	public Evaluationstatus findById(long id) {
		return evaluationStatusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("EvaluationStatus", "id", id));
	}

	@Override
	public Evaluationstatus update(Evaluationstatus Evaluationstatus, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEvaluationstatusById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Evaluationstatus updatePartially(Evaluationstatus Evaluationstatus, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
