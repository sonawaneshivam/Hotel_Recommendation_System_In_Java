package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.AccommodationEntity;
import com.hotel.client.repo.AccommodationRepoImple;
import com.hotel.client.repo.IAccommodationRepo;

public class AccommodationServiceImple implements IAccommodationService {
	private IAccommodationRepo accommodationRepo = new AccommodationRepoImple();

	@Override
	public boolean addAccommodation(AccommodationEntity accommodationEntity) {
		return accommodationRepo.addAccommodation(accommodationEntity);
	}

	@Override
	public List<AccommodationEntity> showAccommodation() {
		return accommodationRepo.showAccommodation();
	}

	@Override
	public boolean updateAccommodation(AccommodationEntity accommodationEntity) {
		return accommodationRepo.updateAccommodation(accommodationEntity);
	}

	@Override
	public boolean deleteAccommodation(int id) {
		return accommodationRepo.deleteAccommodation(id);
	}

	@Override
	public List<AccommodationEntity> serch(String name) {
		// TODO Auto-generated method stub
		return accommodationRepo.serch(name);
	}

	@Override
	public boolean check(int a) {
		// TODO Auto-generated method stub
		return accommodationRepo.check(a);
	}

}
