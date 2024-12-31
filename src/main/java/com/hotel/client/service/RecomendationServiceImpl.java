package com.hotel.client.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hotel.client.config.ClassAndObject;
import com.hotel.client.entity.RecomendationEntity;
import com.hotel.client.repo.IRecomendation;
import com.hotel.client.repo.RecomendationImpl;

public class RecomendationServiceImpl extends ClassAndObject implements IRcomendationService {
	static IRecomendation rs = new RecomendationImpl();

	private double calculateCosineSimilarity(double[] vec1, double[] vec2) {
		double dotProduct = 0.0, normVec1 = 0.0, normVec2 = 0.0;
		for (int i = 0; i < vec1.length; i++) {
			dotProduct += vec1[i] * vec2[i];
			normVec1 += Math.pow(vec1[i], 2);
			normVec2 += Math.pow(vec2[i], 2);
		}
		return (normVec1 == 0 || normVec2 == 0) ? 0 : dotProduct / (Math.sqrt(normVec1) * Math.sqrt(normVec2));
	}

	private double[] extractFeatures(RecomendationEntity hotel) {
		return new double[] { hotel.hasAmenity("Ac") ? 1.0 : 0.0, hotel.hasAmenity("wifi") ? 1.0 : 0.0,
				hotel.hasAmenity("pool") ? 1.0 : 0.0 };
	}

	public List<RecomendationEntity> recommendHotels(RecomendationEntity userPreference,
			List<RecomendationEntity> hotels) {
		double[] userFeatures = extractFeatures(userPreference);
		Map<RecomendationEntity, Double> similarityScores = new HashMap<>();

		for (RecomendationEntity hotel : hotels) {
			double similarity = calculateCosineSimilarity(userFeatures, extractFeatures(hotel));
			similarityScores.put(hotel, similarity);
		}

		return similarityScores.entrySet().stream().sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
				.map(Map.Entry::getKey).toList();
	}

	@Override
	public List<RecomendationEntity> showAllHotelWithoutAcc(int lid, int amid) {
		return rs.showAllHotelWithoutAcc(lid, amid);
	}

	@Override
	public List<RecomendationEntity> showAllHotelWithoutrange(int lid, int amid) {
		return rs.showAllHotelWithoutrange(lid, amid);
	}

}
