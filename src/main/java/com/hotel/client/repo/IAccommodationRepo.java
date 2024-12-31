package com.hotel.client.repo;

import java.util.List;

import com.hotel.client.entity.AccommodationEntity;

public interface IAccommodationRepo {
	public boolean addAccommodation(AccommodationEntity accommodation);

	public List<AccommodationEntity> showAccommodation();

	public boolean updateAccommodation(AccommodationEntity accommodationEntity);

	public boolean deleteAccommodation(int id);
	
	public List<AccommodationEntity> serch(String name);
	
	public boolean check(int a);
}
