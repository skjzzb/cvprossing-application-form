package com.gslab.talent.services.service;

import java.util.List;

import com.gslab.talent.services.entities.Position;

public interface PositionService {

	public void createPosition(Position Position);
	public List<Position> getPosition();
	public Position findById(long id);
	public Position update(Position Position, long l);
	public void deletePositionById(long id);
	public Position updatePartially(Position Position, long id);
	
}
