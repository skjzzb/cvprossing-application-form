package com.gslab.talent.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Candidate;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.CandidateRepository;
import com.gslab.talent.services.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository;
	
	@Override
	public void createCandidate(Candidate candidate) {
		candidateRepository.save(candidate);
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return (List<Candidate>) candidateRepository.findAll();
	}

	@Override
	public Candidate findById(long id) {
		return candidateRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", id));
	}

	@Override
	public Candidate update(Candidate candidate, long l) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void deleteCandidateById(long id) {
		candidateRepository.deleteById(id);
	}

	@Override
	public Candidate updatePartially(Candidate candidate, long id) {
		Candidate candidateLocal = findById(id);
		candidate.setEvaluationstatus(candidateLocal.getEvaluationstatus());
		return candidateRepository.save(candidate);
	}

	@Override
	public Long getCountById() {
		return candidateRepository.count();
	}

	@Override
	public Long getCountByEvaluationstatus(long id) {
		return candidateRepository.countByEvaluationstatus(id);
	}

	@Override
	public Long getCountAllByRejectedProfiles(ArrayList<Integer> ids) {
		return candidateRepository.countAllByReject(ids);
	}

}
