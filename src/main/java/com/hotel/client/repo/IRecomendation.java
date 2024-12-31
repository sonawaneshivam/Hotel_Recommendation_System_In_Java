package com.hotel.client.repo;

import java.util.List;

import com.hotel.client.entity.RecomendationEntity;

public interface IRecomendation {
	public List<RecomendationEntity> showAllHotelWithoutAcc(int lid,int amid);
	public List<RecomendationEntity> showAllHotelWithoutrange(int lid,int amid);
}
