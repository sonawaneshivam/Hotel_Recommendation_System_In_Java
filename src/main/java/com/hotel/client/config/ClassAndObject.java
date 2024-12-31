package com.hotel.client.config;

import java.util.Scanner;

import com.hotel.client.entity.CityEntity;
import com.hotel.client.entity.HotelEntity;
import com.hotel.client.entity.LoginEntity;
import com.hotel.client.entity.RecomendationEntity;
import com.hotel.client.entity.StateEntity;
import com.hotel.client.service.AccommodationServiceImple;
import com.hotel.client.service.AmminitiesServiceImple;
import com.hotel.client.service.CityServiceImple;
import com.hotel.client.service.DistrictServiceImpl;
import com.hotel.client.service.HotelServiceImpl;
import com.hotel.client.service.IAccommodationService;
import com.hotel.client.service.IAmminitiesService;
import com.hotel.client.service.ICityService;
import com.hotel.client.service.IHotelService;
import com.hotel.client.service.ILoginService;
import com.hotel.client.service.IRcomendationService;
import com.hotel.client.service.IStateServices;
import com.hotel.client.service.IUserService;
import com.hotel.client.service.LoginServiceImpl;
import com.hotel.client.service.RecomendationServiceImpl;
import com.hotel.client.service.StateServices;
import com.hotel.client.service.UserSeviceImpl;

public class ClassAndObject {
	protected static LoginEntity le = new LoginEntity();
	protected static StateEntity se = new StateEntity();
    protected static DistrictServiceImpl districtService = new DistrictServiceImpl();
    protected static HotelEntity he = new HotelEntity();
    protected static IHotelService hs = new HotelServiceImpl();
    protected static CityEntity ce = new CityEntity();
    protected static ICityService cs = new CityServiceImple();
    protected static IAccommodationService as = new AccommodationServiceImple();
    protected static IAmminitiesService ams = new AmminitiesServiceImple();
    protected static ILoginService iLoginService = new LoginServiceImpl();
    protected static IStateServices iStateServices = new StateServices();
    protected static IUserService us = new UserSeviceImpl();
    protected static Scanner sc = new Scanner(System.in);
    protected static RecomendationEntity re = new RecomendationEntity();
    protected static IRcomendationService rs = new RecomendationServiceImpl();
}
