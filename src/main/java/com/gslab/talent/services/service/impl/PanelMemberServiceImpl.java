package com.gslab.talent.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.talent.services.entities.Panelmember;
import com.gslab.talent.services.exception.ResourceNotFoundException;
import com.gslab.talent.services.repository.PanelRepository;
import com.gslab.talent.services.service.PanelMemberService;

@Service
@Transactional
public class PanelMemberServiceImpl implements PanelMemberService {

	@Autowired
	PanelRepository panelrepository;
	
	@Override
	public void createPanelmember(Panelmember Panelmember) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Panelmember> getPanelmember() {
		return (List<Panelmember>) panelrepository.findAll();
	}

	@Override
	public Panelmember findById(long id) {
		// TODO Auto-generated method stub
		return panelrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Panel Member", "id", id));
	}

	@Override
	public Panelmember update(Panelmember Panelmember, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePanelmemberById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Panelmember updatePartially(Panelmember Panelmember, long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
