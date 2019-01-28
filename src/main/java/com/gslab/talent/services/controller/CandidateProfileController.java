package com.gslab.talent.services.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gslab.talent.services.entities.Candidate;
import com.gslab.talent.services.model.RecordCount;
import com.gslab.talent.services.service.CandidateService;
import com.gslab.talent.services.utility.Constant;

@RestController
public class CandidateProfileController {
	
	@Autowired
	CandidateService candidateService;


	@GetMapping(value = "/profiles", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Candidate> getAllProfiles() {
		return candidateService.getAllCandidates();
	}

	@GetMapping(value = "/profiles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Candidate> getProfileByContact(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Candidate candidate = candidateService.findById(id);
		if (candidate == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(candidate, HttpStatus.OK);
	}
	
	 @PostMapping(value="/profile",headers="Accept=application/json")
	 public ResponseEntity<Void> createProfile(@RequestBody Candidate candidate, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating Candidate Contact "+candidate.getCandidateContact());
	     candidateService.createCandidate(candidate);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/profiles/{id}").buildAndExpand(candidate.getCandidateId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

	
	@GetMapping(value = "/profile-count", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountById() {
		return new RecordCount("profile-count",candidateService.getCountById());
	}
	
	@GetMapping(value = "/profile-count-by-shortlisted", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByShortListed() {
		return new RecordCount("profile-count-by-shortlisted",candidateService.getCountByEvaluationstatus(Constant.PROFILE_SHORTLIST_INPROGRESS));
	}
	
	@GetMapping(value = "/profile-count-by-tech-inprogress", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByTechInProgress() {
		return new RecordCount("profile-count-by-tech-inprogress",candidateService.getCountByEvaluationstatus(Constant.PROFILE_TECH_INPROGRESS));
	}
	
	@GetMapping(value = "/profile-count-by-manager-inprogress", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByManagerInprogress() {
		return new RecordCount("profile-count-by-manager-inprogress",candidateService.getCountByEvaluationstatus(Constant.PROFILE_MANAGER_INPROGRESS));
	}
	
	@GetMapping(value = "/profile-count-by-hr-inprogress", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByHrInprogress() {
		return new RecordCount("profile-count-by-hr-inprogress",candidateService.getCountByEvaluationstatus(Constant.PROFILE_HR_INPROGRESS));
	}
	
	@GetMapping(value = "/profile-count-by-offered", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByOffered() {
		//FIXME: Need to add parameter for offered constant
		return new RecordCount("profile-count-by-offered",candidateService.getCountByEvaluationstatus(Constant.PROFILE_HR_OFFERED));
	}
	
	@GetMapping(value = "/profile-count-by-rejected", produces = MediaType.APPLICATION_JSON_VALUE)
	public RecordCount getProfileCountByRejected() {
		return new RecordCount("profile-count-by-rejected",candidateService.getCountAllByRejectedProfiles(
				new ArrayList<Integer>(
						Arrays.asList(
								Constant.PROFILE_SHORTLIST_REJECT,
								Constant.PROFILE_TECH_REJECT,
								Constant.PROFILE_MAHAGER_REJECT,
								Constant.PROFILE_HR_REJECT,
								Constant.PROFILE_OFFER_REJECT)
						)
				));
	}
}
