package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Interviewerlevel;

public interface InterviewerLevelService {

	public void createInterviewerlevel(Interviewerlevel Interviewerlevel);
	public List<Interviewerlevel> getInterviewerlevel();
	public Interviewerlevel findById(long id);
	public Interviewerlevel update(Interviewerlevel Interviewerlevel, long l);
	public void deleteInterviewerlevelById(long id);
	public Interviewerlevel updatePartially(Interviewerlevel Interviewerlevel, long id);
}
