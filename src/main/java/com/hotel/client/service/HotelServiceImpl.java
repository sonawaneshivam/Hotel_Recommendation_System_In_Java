package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.CityEntity;
import com.hotel.client.entity.HotelEntity;
import com.hotel.client.entity.RecomendationEntity;
import com.hotel.client.repo.HotelRepoImpl;
import com.hotel.client.repo.IHotelRepo;

public class HotelServiceImpl implements IHotelService {
	IHotelRepo hs=new  HotelRepoImpl();
	@Override
	public int getLocationId(CityEntity ce) {
		// TODO Auto-generated method stub
		return hs.getLocationId(ce);
	}
	@Override
	public boolean insertIntoHotel(HotelEntity he) {
		// TODO Auto-generated method stub
		return hs.insertIntoHotel(he);
	}
	@Override
	public int hotelId() {
		// TODO Auto-generated method stub
		return hs.hotelId();
	}
	@Override
	public boolean insertIntoAminityJoin(int hid, int amid) {
		// TODO Auto-generated method stub
		return hs.insertIntoAminityJoin(hid, amid);
	}
	@Override
	public List<HotelEntity> showAllHotel(int l_id) {
		// TODO Auto-generated method stub
		return hs.showAllHotel(l_id);
	}
	@Override
	public List<HotelEntity> serchHotel(int l_id, String name) {
		// TODO Auto-generated method stub
		return hs.serchHotel(l_id, name);
	}
	@Override
	public boolean deleteHotel(int hotelId,int lid) {
		// TODO Auto-generated method stub
		return hs.deleteHotel(hotelId,lid);
	}
	@Override
	public boolean checkPresence(int hid, int lid) {
		// TODO Auto-generated method stub
		return hs.checkPresence(hid, lid);
	}
	@Override
	public boolean updateHotelName(String name, int hid) {
		// TODO Auto-generated method stub
		return hs.updateHotelName(name, hid);
	}
	@Override
	public boolean updateHotelContatc(String contact, int hid) {
		// TODO Auto-generated method stub
		return hs.updateHotelContatc(contact, hid);
	}
	@Override
	public boolean updateHotelPrice(int price, int hid) {
		// TODO Auto-generated method stub
		return hs.updateHotelPrice(price, hid);
	}
	@Override
	public List<RecomendationEntity> showAllHotelWithAcc(int l_id, int am_id,int min,int max) {
		// TODO Auto-generated method stub
		return hs.showAllHotelWithAcc(l_id, am_id,min,max);
	}

}
