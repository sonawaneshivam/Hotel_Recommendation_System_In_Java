package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationEntity extends CityEntity {
	private Integer accommodationID;
	private String typeOfAccommodation;
}
