package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.RecomendationEntity;

public interface IRcomendationService {
	 public  List<RecomendationEntity> recommendHotels(RecomendationEntity userPreference, List<RecomendationEntity> hotels);
	 public List<RecomendationEntity> showAllHotelWithoutAcc(int lid,int amid);
	 public List<RecomendationEntity> showAllHotelWithoutrange(int lid,int amid);
}
