package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.AmminitiesEntity;

public interface IAmminitiesService {
	public boolean addAmminity(AmminitiesEntity amminitiesEntity);

	public List<AmminitiesEntity> showAmmnity();

	public boolean updateAmminity(AmminitiesEntity amminitiesEntity);

	public boolean deleteAmminity(int deleteID);
	public List<AmminitiesEntity> search(String name);
	public boolean checkAminity(int amid);
	
}
