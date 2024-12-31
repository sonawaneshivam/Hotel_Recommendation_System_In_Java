package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.StateEntity;
import com.hotel.client.repo.StateRepoImple;

public class StateServices implements IStateServices{
	private StateRepoImple stateRepoImple=new StateRepoImple();
	@Override
	public boolean addState(StateEntity stateEntity) {
		// TODO Auto-generated method stub
		return stateRepoImple.addState(stateEntity);
	}

	

	@Override
	public boolean deleteState(int stateId) {
		// TODO Auto-generated method stub
		return stateRepoImple.deleteState(stateId);
	}

	@Override
	public boolean updateState(StateEntity stateEntity) {
		// TODO Auto-generated method stub
		return stateRepoImple.updateState(stateEntity);
	}

	@Override
	public List<StateEntity> getAllStates() {
		// TODO Auto-generated method stub
		return stateRepoImple.getAllStates();
	}



	@Override
	public List<StateEntity> searchState(String stateName) {
		// TODO Auto-generated method stub
		return stateRepoImple.searchState(stateName);
	}



	@Override
	public int getSatteIdByName(String statename) {
		// TODO Auto-generated method stub
		return stateRepoImple.getSatteIdByName(statename);
	}

}