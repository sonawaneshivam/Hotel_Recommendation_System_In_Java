package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.StateEntity;

public interface IStateServices {
	public boolean addState(StateEntity stateEntity);

	public boolean deleteState(int stateId);

	public boolean updateState(StateEntity stateEntity);
	
	public List<StateEntity> getAllStates();
	
	public List<StateEntity> searchState(String stateName);
	
	public int getSatteIdByName(String statename);
	
}