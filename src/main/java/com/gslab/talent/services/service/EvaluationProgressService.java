package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Evaluationprogress;

public interface EvaluationProgressService {
	
	public void createEvaluationProgress(Evaluationprogress evaluationprogress);
	public List<Evaluationprogress> getAllEvaluationProgress();
	public Evaluationprogress findById(long id);
	public Evaluationprogress update(Evaluationprogress evaluationprogress, long l);
	public void deleteEvaluationProgressById(long id);
	public Evaluationprogress updatePartially(Evaluationprogress evaluationprogress, long id);
	
}
