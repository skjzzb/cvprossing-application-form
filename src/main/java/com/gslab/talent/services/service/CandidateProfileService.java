package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.CandidateProfile;

public interface CandidateProfileService {

	public void createCandidateProfile(CandidateProfile candidateProfile);
	public List<CandidateProfile> getAllCandidatesProfiles();
	public CandidateProfile findById(long id);
	public CandidateProfile update(CandidateProfile candidateProfile, long l);
	public void deleteCandidateProfileById(long id);
	public CandidateProfile updatePartially(CandidateProfile candidateProfile, long id);
	
}
