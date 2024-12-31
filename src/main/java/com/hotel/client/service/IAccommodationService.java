package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.AccommodationEntity;

public interface IAccommodationService {
	public boolean addAccommodation(AccommodationEntity accommodationEntity);

	public List<AccommodationEntity> showAccommodation();

	public boolean updateAccommodation(AccommodationEntity accommodationEntity);

	public boolean deleteAccommodation(int id);
	
	public List<AccommodationEntity> serch(String name);
	
	public boolean check(int a);
}
