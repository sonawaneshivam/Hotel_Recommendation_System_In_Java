package com.hotel.client.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelEntity extends AmminitiesEntity{
	private int hid;
	private String hname;
	private String hconatct;
	private String haddress;
	private int hprice;
	private int lid;
	
}
