package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Evaluationprogress;
import com.gslab.talent.services.service.EvaluationProgressService;

@Service
@Transactional
public class EvaluationProgressServiceImpl implements EvaluationProgressService {

	@Override
	public void createEvaluationProgress(Evaluationprogress evaluationprogress) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Evaluationprogress> getAllEvaluationProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluationprogress findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evaluationprogress update(Evaluationprogress evaluationprogress, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEvaluationProgressById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Evaluationprogress updatePartially(Evaluationprogress evaluationprogress, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
