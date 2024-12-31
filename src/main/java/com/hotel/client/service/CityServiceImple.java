package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.CityEntity;
import com.hotel.client.repo.CityRepoImple;
import com.hotel.client.repo.ICityRepo;

public class CityServiceImple implements ICityService{
	ICityRepo cs=new CityRepoImple();
	@Override
	public int getCityIdByName(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.getCityIdByName(ce);
	}
	@Override
	public boolean insertDataWithProcedure(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.insertDataWithProcedure(ce);
	}
	@Override
	public boolean checkPrsentOrNot(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.checkPrsentOrNot(ce);
	}
	@Override
	public boolean filledInJoin(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.filledInJoin(ce);
	}
	@Override
	public List<CityEntity> showAllCities(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.showAllCities(ce);
	}
	@Override
	public int getCount(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.getCount(ce);
	}
	@Override
	public boolean updateJoin(CityEntity ce,int newId) {
		// TODO Auto-generated method stub
		return cs.updateJoin(ce,newId);
	}
	@Override
	public boolean insertDataInCity(String city) {
		// TODO Auto-generated method stub
		return cs.insertDataInCity(city);
	}
	@Override
	public boolean delteCity(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.delteCity(ce);
	}
	@Override
	public List<CityEntity> serchCity(CityEntity ce) {
		// TODO Auto-generated method stub
		return cs.serchCity(ce);
	}

}
