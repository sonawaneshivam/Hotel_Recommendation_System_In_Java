package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.AmminitiesEntity;
import com.hotel.client.repo.AmminityRepoImple;
import com.hotel.client.repo.IAmminityRepo;

public class AmminitiesServiceImple implements IAmminitiesService {
	private IAmminityRepo amminityRepo = new AmminityRepoImple();

	@Override
	public boolean addAmminity(AmminitiesEntity amminitiesEntity) {
		return amminityRepo.addAmminity(amminitiesEntity);
	}

	@Override
	public List<AmminitiesEntity> showAmmnity() {
		return amminityRepo.showAmminities();
	}

	@Override
	public boolean updateAmminity(AmminitiesEntity amminitiesEntity) {
		return amminityRepo.updateAmminity(amminitiesEntity);
	}

	@Override
	public boolean deleteAmminity(int deleteId) {
		return amminityRepo.deleteAmminity(deleteId);
	}

	@Override
	public List<AmminitiesEntity> search(String name) {
		// TODO Auto-generated method stub
		return amminityRepo.search(name);
	}

	@Override
	public boolean checkAminity(int amid) {
		// TODO Auto-generated method stub
		return amminityRepo.checkAminity(amid);
	}

}
