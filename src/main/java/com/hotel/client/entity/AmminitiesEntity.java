package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AmminitiesEntity extends AccommodationEntity {
	private Integer aminitiesID;
	private String amminitiesName;
	private double ammnitiesPrice;
	 
}
