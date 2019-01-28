package com.gslab.talent.services.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.gslab.talent.services.entities.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Long> {

	long countByEvaluationstatus(Long id);
	long countAllByReject(ArrayList<Integer> ids);
	
}
