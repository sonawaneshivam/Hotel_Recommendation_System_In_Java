package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistrictEntity extends StateEntity {
	
	private int distId;
	private String distName;
}

