package com.gslab.talent.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.talent.services.entities.Evaluationstatus;
import com.gslab.talent.services.entities.Interviewerlevel;
import com.gslab.talent.services.entities.Isavailableforinterview;
import com.gslab.talent.services.entities.Modeofinterview;
import com.gslab.talent.services.entities.Panelmember;
import com.gslab.talent.services.entities.Position;
import com.gslab.talent.services.service.EvaluationStatusService;
import com.gslab.talent.services.service.InterviewerLevelService;
import com.gslab.talent.services.service.IsAvailableForInterviewService;
import com.gslab.talent.services.service.ModeOfInterviewService;
import com.gslab.talent.services.service.PanelMemberService;
import com.gslab.talent.services.service.PositionService;

@RestController
public class MasterDataController {

	@Autowired
	EvaluationStatusService evaluationStatusService;

	@Autowired
	PositionService positionservice;
	
	@Autowired
	PanelMemberService panelmember;
	
	@Autowired
	ModeOfInterviewService modeOfInterview;
	
	@Autowired
	InterviewerLevelService interviewerLevel;
	
	@Autowired
	IsAvailableForInterviewService isAvailableForInterview;
	
	@GetMapping(value = "/evaluationstatus", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Evaluationstatus> getAllEvaluationStatus() {
		return evaluationStatusService.getEvaluationstatus();
	}

	@GetMapping(value = "/evaluationstatus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Evaluationstatus> getEvaluationStatusById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Evaluationstatus evaluationstatus = evaluationStatusService.findById(id);
		if (evaluationstatus == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(evaluationstatus, HttpStatus.OK);
	}
	
	@GetMapping(value = "/positions", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Position> getAllPosition() {
		return positionservice.getPosition();
	}

	@GetMapping(value = "/positions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Position> getPositionById(@PathVariable("id") long id) {
		System.out.println("Fetching Position with id " + id);
		Position position = positionservice.findById(id);
		if (position == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(position, HttpStatus.OK);
	}
	
	@GetMapping(value = "/panelmembers", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Panelmember> getAllPanelMember() {
		return panelmember.getPanelmember();
	}

	@GetMapping(value = "/panelmembers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Panelmember> getPanelMembersById(@PathVariable("id") long id) {
		System.out.println("Fetching panal members with id " + id);
		Panelmember panelMembers = panelmember.findById(id);
		if (panelMembers == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(panelMembers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/modeofinterviews", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Modeofinterview> getAllModeOfInterviews() {
		return modeOfInterview.getModeofinterview();
	}

	@GetMapping(value = "/modeofinterviews/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modeofinterview> getModeOfInterviewById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Modeofinterview modeOfInterviewObj = modeOfInterview.findById(id);
		if (modeOfInterviewObj == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(modeOfInterviewObj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/interviewerlevels", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Interviewerlevel> getAllInterviewerLevel() {
		return interviewerLevel.getInterviewerlevel();
	}

	@GetMapping(value = "/interviewerlevels/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Interviewerlevel> getInterviewerLevelById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Interviewerlevel interviewerlevel = interviewerLevel.findById(id);
		if (interviewerlevel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(interviewerlevel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/isavailableforinterview", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Isavailableforinterview> getIsCandidateAvailableForInterview() {
		return isAvailableForInterview.getIsAvailableForInterview();
	}

	@GetMapping(value = "/isavailableforinterview/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Isavailableforinterview> getIsCandidateAvailableForInterviewById(@PathVariable("id") long id) {
		System.out.println("Fetching User with id " + id);
		Isavailableforinterview isAvailableforInterview = isAvailableForInterview.findById(id);
		if (isAvailableforInterview == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(isAvailableforInterview, HttpStatus.OK);
	}
	
}
