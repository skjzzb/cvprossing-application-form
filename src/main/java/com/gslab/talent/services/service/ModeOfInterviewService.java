package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Modeofinterview;

public interface ModeOfInterviewService {

	public void createModeofinterview(Modeofinterview Modeofinterview);
	public List<Modeofinterview> getModeofinterview();
	public Modeofinterview findById(long id);
	public Modeofinterview update(Modeofinterview Modeofinterview, long l);
	public void deleteModeofinterviewById(long id);
	public Modeofinterview updatePartially(Modeofinterview Modeofinterview, long id);
	
}
