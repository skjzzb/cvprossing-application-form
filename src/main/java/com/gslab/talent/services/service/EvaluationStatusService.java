package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Evaluationstatus;

public interface EvaluationStatusService {

	public void createEvaluationstatus(Evaluationstatus Evaluationstatus);
	public List<Evaluationstatus> getEvaluationstatus();
	public Evaluationstatus findById(long id);
	public Evaluationstatus update(Evaluationstatus Evaluationstatus, long l);
	public void deleteEvaluationstatusById(long id);
	public Evaluationstatus updatePartially(Evaluationstatus Evaluationstatus, long id);
	
}
