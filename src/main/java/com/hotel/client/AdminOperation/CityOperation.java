package com.hotel.client.AdminOperation;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hotel.client.config.ClassAndObject;
import com.hotel.client.entity.CityEntity;
import com.hotel.client.entity.DistrictEntity;
import com.hotel.client.entity.StateEntity;

public class CityOperation extends ClassAndObject {
	static Logger logger = Logger.getLogger(CityOperation.class);

    // Static block to configure the logger with the properties file
    static {
        try {
            PropertyConfigurator.configure("E:\\workspace\\Core Java\\hotel-recommendatioin\\src\\main\\resources\\log.properties");
            
        } catch (Exception e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }
	public CityOperation() {
		int choice = 0;
		do {
			System.out.println("");
			System.out.println("1)Add city");
			System.out.println("2)Show All city");
			System.out.println("3)Update city");
			System.out.println("4)Delete city");
			System.out.println("5)Search city");
			System.out.println("6)Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				logger.info("new city is added");
				addCity();
				break;
			case 2:
				showCities();
				break;
			case 3:
				logger.info("city is updated");
				updateCity();
				break;
			case 4:
				logger.info("city is deleted");
				deleteCity();
				break;
			case 5:
				searchCity();
				break;
			case 6:

				break;
			default:
				System.out.println("Invalid operation.....");
				break;
			}
		} while (choice != 6);

	}

	public static void addCity() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = new ArrayList<DistrictEntity>();
			dist = districtService.showAllDistrcitWhitState(stateId);
			System.out.println("*****************District********************");
			System.out.println("District_id\t District_Name");
			dist.forEach((t) -> System.out.println(t.getDistId() + "\t\t" + t.getDistName()));
			System.out.println("Enter the District name to add city");
			String distName = sc.nextLine();
			int distId = districtService.getDistIdByName(distName);
			if (distId != 0) {
				System.out.println("Enter the city name");
				String cityname = sc.nextLine();
				ce.setCityName(cityname);
				ce.setS_id(stateId);
				ce.setDistId(distId);
				int cityId = cs.getCityIdByName(ce);
				ce.setCityId(cityId);
				if (cityId == 0) {
					
					if (cs.insertDataWithProcedure(ce)) {
						System.out.println("data is filled");
					} else {
						System.out.println("somthing is not workin");
					}
				} else if (cs.checkPrsentOrNot(ce)) {
					if (cs.filledInJoin(ce)) {
						System.out.println("data is filled");
					} else {
						System.out.println("somthing is not workin");
					}

				} else {
					System.out.println("alredy prsent");
				}

			} else {
				System.out.println("District is not found");
			}
		} else {
			System.err.println("you enter wrong state name");
		}

	}

	public static void showCities() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = new ArrayList<DistrictEntity>();
			dist = districtService.showAllDistrcitWhitState(stateId);
			if (dist.size() != 0) {
				System.out.println("*****************District********************");
				System.out.println("District_id\t District_Name");
				dist.forEach((t) -> System.out.println(t.getDistId() + "\t\t" + t.getDistName()));
				System.out.println("Enter the District to see cities");
				String distName = sc.nextLine();
				int distId = districtService.getDistIdByName(distName);
				if (distId != 0) {
					ce.setS_id(stateId);
					ce.setDistId(distId);

					List<CityEntity> cities = new ArrayList<CityEntity>();
					cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));
					} else {
						System.out.println("assoicate district have no cities");
					}
				} else {
					System.out.println("District is not found");
				}
			} else {
				System.out.println("associate state have no districts");
			}
		} else {
			System.err.println("you enter wrong state name");
		}
	}

	public static void updateCity() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = new ArrayList<DistrictEntity>();
			dist = districtService.showAllDistrcitWhitState(stateId);
			if (dist.size() != 0) {
				System.out.println("*****************District********************");
				System.out.println("District_id\t District_Name");
				dist.forEach((t) -> System.out.println(t.getDistId() + "\t\t" + t.getDistName()));
				System.out.println("Enter the District to see cities");
				String distName = sc.nextLine();
				int distId = districtService.getDistIdByName(distName);
				if (distId != 0) {
					ce.setS_id(stateId);
					ce.setDistId(distId);

					List<CityEntity> cities = new ArrayList<CityEntity>();
					cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));
						System.out.println("Enter the city name that we want to update");
						String oldCity = sc.nextLine();
						System.out.println("Enter the new city name");
						String newCity = sc.nextLine();
						ce.setCityName(oldCity);
						ce.setCityId(cs.getCityIdByName(ce));
						ce.setDistId(distId);
						ce.setS_id(stateId);

						ce.setCityName(newCity);
						int newCityId = 0;
						newCityId = cs.getCityIdByName(ce);
						if (newCityId == 0) {
							if (cs.insertDataInCity(newCity)) {
								newCityId = cs.getCityIdByName(ce);
							} else {
								System.out.println("new city is not added");
							}
						}
//						System.out.println(newCityId+"\t"+ce.getS_id()+"\t"+ce.getDistId()+"\t"+ce.getCityId());
						if (cs.updateJoin(ce, newCityId)) {
							System.out.println("Updated");
						} else {
							System.out.println("not Updated");
						}
					} else {
						System.out.println("assoicate district have no cities");
					}
				} else {
					System.out.println("District is not found");
				}
			} else {
				System.out.println("associate state have no districts");
			}
		} else {
			System.err.println("you enter wrong state name");
		}
	}
	
	
	
	public static void deleteCity() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = new ArrayList<DistrictEntity>();
			dist = districtService.showAllDistrcitWhitState(stateId);
			if (dist.size() != 0) {
				System.out.println("*****************District********************");
				System.out.println("District_id\t District_Name");
				dist.forEach((t) -> System.out.println(t.getDistId() + "\t\t" + t.getDistName()));
				System.out.println("Enter the District to see cities");
				String distName = sc.nextLine();
				int distId = districtService.getDistIdByName(distName);
				if (distId != 0) {
					ce.setS_id(stateId);
					ce.setDistId(distId);

					List<CityEntity> cities = new ArrayList<CityEntity>();
					cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));
						System.out.println("enter the City Name that you want to delete");
						String cityName=sc.nextLine();
						ce.setCityName(cityName);
						int cityId=cs.getCityIdByName(ce);
						ce.setCityId(cityId);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						if (cs.delteCity(ce)) {
							System.out.println("city deleted successfully");
						} else {
//							System.out.println(ce.getDistId()+"\t"+ce.getCityName()+"\t"+ce.getS_id());
							System.out.println(" not delete city");
						}
						
					} else {
						System.out.println("assoicate district have no cities");
					}
				} else {
					System.out.println("District is not found");
				}
			} else {
				System.out.println("associate state have no districts");
			}
		} else {
			System.err.println("you enter wrong state name");
		}
	}
	
	
	public static void searchCity() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = new ArrayList<DistrictEntity>();
			dist = districtService.showAllDistrcitWhitState(stateId);
			if (dist.size() != 0) {
				System.out.println("*****************District********************");
				System.out.println("District_id\t District_Name");
				dist.forEach((t) -> System.out.println(t.getDistId() + "\t\t" + t.getDistName()));
				System.out.println("Enter the District to see cities");
				String distName = sc.nextLine();
				int distId = districtService.getDistIdByName(distName);
				if (distId != 0) {
					ce.setS_id(stateId);
					ce.setDistId(distId);

					List<CityEntity> cities = new ArrayList<CityEntity>();
					cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));
						
						System.out.println("Enter the city name to search");
						String city=sc.nextLine();
						ce.setCityName(city);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						cities=cs.serchCity(ce);
						if (cities.size()!=0) {
							cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));
						} else {
//							System.out.println(ce.getDistId()+"\t"+ce.getCityName()+"\t"+ce.getS_id());
							System.out.println("cities not found");
						}
						
					} else {
						System.out.println("assoicate district have no cities");
					}
				} else {
					System.out.println("District is not found");
				}
			} else {
				System.out.println("associate state have no districts");
			}
		} else {
			System.err.println("you enter wrong state name");
		}
	}
}




