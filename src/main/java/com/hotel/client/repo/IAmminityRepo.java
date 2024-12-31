package com.hotel.client.repo;

import java.util.List;

import com.hotel.client.entity.AmminitiesEntity;

public interface IAmminityRepo {
	public boolean addAmminity(AmminitiesEntity amminitiesEntity);

	public List<AmminitiesEntity> showAmminities();

	public boolean updateAmminity(AmminitiesEntity amminitiesEntity);

	public boolean deleteAmminity(int amminitiesEntity);
	
	public List<AmminitiesEntity> search(String name);
	
	public boolean checkAminity(int amid);
}
