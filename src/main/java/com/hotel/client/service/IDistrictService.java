package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.DistrictEntity;

public interface IDistrictService {
	public int getDistIdByName(String distname);
	public boolean distAddedByProcedure(DistrictEntity de);
	public boolean checkDIstrikIsPreset(DistrictEntity de);
	public boolean insertIntoStateDistrict(DistrictEntity de);
	public List<DistrictEntity> showAllDistrcitWhitState(int stateID);
	public boolean checkDistrictPrestent(DistrictEntity de);
	public boolean CheckDistricAndStatePresent(DistrictEntity de);
	public boolean insertDataInJoin(DistrictEntity de);
	public boolean newDistrict(DistrictEntity de);
	
	public List<DistrictEntity> searchDist(DistrictEntity de);
	public int checkDistCount(DistrictEntity de);
	
	public boolean delteFromJoin(DistrictEntity de);
	public boolean deleteFromTables(DistrictEntity de);
}