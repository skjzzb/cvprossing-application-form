package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Interviewerlevel;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.InterviewerLevelRepository;
import com.gslab.talent.services.service.InterviewerLevelService;
@Service
@Transactional
public class InterviewerLevelServiceImpl implements InterviewerLevelService {

	@Autowired
	InterviewerLevelRepository interviewerLevelRepository;
	
	@Override
	public void createInterviewerlevel(Interviewerlevel Interviewerlevel) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Interviewerlevel> getInterviewerlevel() {
		
		return (List<Interviewerlevel>) interviewerLevelRepository.findAll();
	}

	@Override
	public Interviewerlevel findById(long id) {
		return interviewerLevelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Interviewer Level", "id", id));
	}

	@Override
	public Interviewerlevel update(Interviewerlevel Interviewerlevel, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInterviewerlevelById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Interviewerlevel updatePartially(Interviewerlevel Interviewerlevel, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
