package com.gslab.talent.services.service;

import java.util.ArrayList;
import java.util.List;

import com.gslab.talent.services.entities.Candidate;

public interface CandidateService {

	public void createCandidate(Candidate candidate);
	public List<Candidate> getAllCandidates();
	public Candidate findById(long id);
	public Candidate update(Candidate candidate, long l);
	public void deleteCandidateById(long id);
	public Candidate updatePartially(Candidate candidate, long id);
	public Long getCountById();
	public Long getCountByEvaluationstatus(long id);
	public Long getCountAllByRejectedProfiles(ArrayList<Integer> ids);
	
}
