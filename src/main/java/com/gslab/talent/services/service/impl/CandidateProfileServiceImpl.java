package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.CandidateProfile;
import com.gslab.talent.services.repository.CandidateProfileRepository;
import com.gslab.talent.services.service.CandidateProfileService;

@Service
@Transactional
public class CandidateProfileServiceImpl implements CandidateProfileService {

	@Autowired
	private CandidateProfileRepository candidateProfileRepository;
	
	@Override
	public void createCandidateProfile(CandidateProfile candidateProfile) {
		// TODO Auto-generated method stub
		candidateProfileRepository.save(candidateProfile);
	}

	@Override
	public List<CandidateProfile> getAllCandidatesProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateProfile findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateProfile update(CandidateProfile candidateProfile, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCandidateProfileById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public CandidateProfile updatePartially(CandidateProfile candidateProfile, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
