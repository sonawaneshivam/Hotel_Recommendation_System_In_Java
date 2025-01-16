package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.DistrictEntity;
import com.hotel.client.repo.DistrictRepoImpl;
import com.hotel.client.repo.IDistrictRepo;

public class DistrictServiceImpl implements IDistrictService {
	static IDistrictRepo districtRepo=new DistrictRepoImpl();
	@Override
	public int getDistIdByName(String distname) {
		// TODO Auto-generated method stub
		return districtRepo.getDistIdByName(distname);
	}
	@Override
	public boolean distAddedByProcedure(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.distAddedByProcedure(de);
	}
	@Override
	public boolean checkDIstrikIsPreset(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.checkDIstrikIsPreset(de);
		}
	@Override
	public boolean insertIntoStateDistrict(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.insertIntoStateDistrict(de);
	}
	@Override
	public List<DistrictEntity> showAllDistrcitWhitState(int stateID) {
		// TODO Auto-generated method stub
		return districtRepo.showAllDistrcitWhitState(stateID);
	}
	@Override
	public boolean checkDistrictPrestent(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.checkDistrictPrestent(de);
	}
	@Override
	public boolean CheckDistricAndStatePresent(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.CheckDistricAndStatePresent(de);
	}
	@Override
	public boolean insertDataInJoin(DistrictEntity de,int old) {
		// TODO Auto-generated method stub
		return districtRepo.insertDataInJoin(de,old);
	}
	@Override
	public boolean newDistrict(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.newDistrict(de);
	}
	@Override
	public List<DistrictEntity> searchDist(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.searchDist(de);
	}
	@Override
	public int checkDistCount(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.checkDistCount(de);
	}
	@Override
	public boolean delteFromJoin(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.delteFromJoin(de);
	}
	@Override
	public boolean deleteFromTables(DistrictEntity de) {
		// TODO Auto-generated method stub
		return districtRepo.deleteFromTables(de);
	}
	
}