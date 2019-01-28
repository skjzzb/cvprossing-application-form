package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Panelmember;

public interface PanelMemberService {

	public void createPanelmember(Panelmember Panelmember);
	public List<Panelmember> getPanelmember();
	public Panelmember findById(long id);
	public Panelmember update(Panelmember Panelmember, long l);
	public void deletePanelmemberById(long id);
	public Panelmember updatePartially(Panelmember Panelmember, long id);
	
}
