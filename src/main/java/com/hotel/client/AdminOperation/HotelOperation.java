package com.hotel.client.AdminOperation;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hotel.client.config.ClassAndObject;
import com.hotel.client.entity.CityEntity;
import com.hotel.client.entity.DistrictEntity;
import com.hotel.client.entity.HotelEntity;
import com.hotel.client.entity.StateEntity;

public class HotelOperation extends ClassAndObject {
	
	static DistrictEntity de = new DistrictEntity();
	static Logger logger = Logger.getLogger(HotelOperation.class);

    // Static block to configure the logger with the properties file
    static {
        try {
            PropertyConfigurator.configure("E:\\workspace\\Core Java\\hotel-recommendatioin\\src\\main\\resources\\log.properties");
            
        } catch (Exception e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }
	public HotelOperation() {

		int choice = 0;
		do {
			System.out.println("");
			System.out.println("1)Add Hotel");
			System.out.println("2)Show All Hotel");
			System.out.println("3)Update Hotel");
			System.out.println("4)Delete Hotel");
			System.out.println("5)Search Hotel");
			System.out.println("6)Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				logger.info("new hotel is added");
				addHotel();
				break;
			case 2:
				showHotesl();
				break;
			case 3:
				logger.info("hotel is updated");
				updateHotel();
				break;
			case 4:
				logger.info("hotel is deleted");
				deleteHotel();
				break;
			case 5:
				searchHotel();
				break;
			case 6:

				break;
			default:
				System.out.println("Invalid operation.....");
				break;
			}
		} while (choice != 6);

	}

	private void addHotel() {
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

						System.out.println("Enter city name to add hotel");
						String cityNamw = sc.nextLine();
						ce.setCityName(cityNamw);
						int cityId = cs.getCityIdByName(ce);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						ce.setCityId(cityId);
						if (cityId != 0) {
							int lid = hs.getLocationId(ce);
							System.out.println("Enter the hotel name");
							String hname = sc.nextLine();
							System.out.println("Enetr the hotel Address");
							String hadd = sc.nextLine();
							System.out.println("Enter the contact number of hotel");
							String hconatct = sc.nextLine();
							if (hconatct.length() == 10) {
								System.out.println("Enter the price of hotel");
								int price = sc.nextInt();
								sc.nextLine();
								AccommodationOperation.showAccommodation();
								System.out.println("Enter the Id of  Accommodation");
								int aid = sc.nextInt();
								sc.nextLine();
								if (as.check(aid)) {
									he.setHname(hname);
									he.setHaddress(hadd);
									he.setHconatct(hconatct);
									he.setLid(lid);
									he.setHprice(price);
									he.setAccommodationID(aid);

									if (hs.insertIntoHotel(he)) {
										String msg = "";
										System.out.println("Do you want to add aminity?(yes/no)");
										
										msg = sc.nextLine().toLowerCase();
										if (msg.equals("yes")) {
											do {
												int hid = hs.hotelId();
												AmminitiesOperatin.showAmminities();
												System.out.println("Enter the Aminity Id to add");
												int ami = sc.nextInt();
												sc.nextLine();
												if (ams.checkAminity(ami)) {
													if (hs.insertIntoAminityJoin(hid, ami)) {
														System.out.println("Data is filled.....");
													} else {
														System.out.println("failed to insert data");
													}
												} else {
													System.out.println("you enter wrong aminity id");
												}
												System.out.println("do you want to add more animity");
												System.out.println("Enter yes or no");
												msg = sc.nextLine().toLowerCase();
											} while (msg.equals("yes"));
										} else {
											System.out.println("Thank You....");
										}
									} else {
										System.out.println("data in not inserted");
									}
								} else {
									System.out.println("you enter the wrong ID");
								}

							} else {
								System.out.println("you enter the wrong number");
							}
						} else {
							System.out.println("city is not found");
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

	private void showHotesl() {
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

						System.out.println("Enter city name to see hotel");
						String cityNamw = sc.nextLine();
						ce.setCityName(cityNamw);
						int cityId = cs.getCityIdByName(ce);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						ce.setCityId(cityId);
						if (cityId != 0) {
							int lid = hs.getLocationId(ce);
							List<HotelEntity> hotels = new ArrayList<HotelEntity>();
							hotels = hs.showAllHotel(lid);
							if (hotels.size() != 0) {
								System.out.println(
										"******************************Hotels*****************************************");
								System.out.println("");
								hotels.forEach((t) -> System.out.println("Id = "+t.getHid() + "\t Hotel Name=" + t.getHname() + "\t Address = "
										+ t.getHaddress() + "\t  Type = " + t.getTypeOfAccommodation() + "\t price = "
										+ t.getHprice() + "\nAminities = " + t.getAmminitiesName()
										+ "\n--------------------------------------------------------------------------------------------------------------------------------------------"));
							} else {
								System.out.println("their are no hotels");
							}

						} else {
							System.out.println("city is not found");
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

	private void searchHotel() {
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

						System.out.println("Enter city name to see hotel");
						String cityNamw = sc.nextLine();
						ce.setCityName(cityNamw);
						int cityId = cs.getCityIdByName(ce);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						ce.setCityId(cityId);
						if (cityId != 0) {
							int lid = hs.getLocationId(ce);
							List<HotelEntity> hotels = new ArrayList<HotelEntity>();
							hotels = hs.showAllHotel(lid);
							if (hotels.size() != 0) {
								System.out.println(
										"******************************Hotels*****************************************");
								System.out.println("");
								hotels.forEach((t) -> System.out.println("Id = "+t.getHid() + "\t Hotel Name=" + t.getHname() + "\t Address = "
										+ t.getHaddress() + "\t  Type = " + t.getTypeOfAccommodation() + "\t price = "
										+ t.getHprice() + "\nAminities = " + t.getAmminitiesName()
										+ "\n--------------------------------------------------------------------------------------------------------------------------------------------"));

								System.out.println("Enter the hotel name to search hotel");
								String hotelname = sc.nextLine();
								hotels = hs.serchHotel(lid, hotelname);
								if (hotels.size() != 0) {
									hotels.forEach((t) -> System.out.println("Id = "+t.getHid() + "\t Hotel Name=" + t.getHname() + "\t Address = "
											+ t.getHaddress() + "\t  Type = " + t.getTypeOfAccommodation() + "\t price = "
											+ t.getHprice() + "\nAminities = " + t.getAmminitiesName()
											+ "\n--------------------------------------------------------------------------------------------------------------------------------------------"));
								} else {
									System.out.println("search hotel is not found");
								}

							} else {
								System.out.println("their are no hotels");
							}

						} else {
							System.out.println("city is not found");
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

	private void deleteHotel() {

		
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = districtService.showAllDistrcitWhitState(stateId);
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

					List<CityEntity> cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));

						System.out.println("Enter city name to see hotels");
						String cityNamw = sc.nextLine();
						ce.setCityName(cityNamw);
						int cityId = cs.getCityIdByName(ce);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						ce.setCityId(cityId);
						if (cityId != 0) {
							int lid = hs.getLocationId(ce);
							List<HotelEntity> hotels = hs.showAllHotel(lid);
							if (hotels.size() != 0) {
								System.out.println(
										"******************************Hotels*****************************************");
								System.out.println("");
								hotels.forEach((t) -> System.out.println("Id = "+t.getHid() + "\t Hotel Name=" + t.getHname() + "\t Address = "
										+ t.getHaddress() + "\t  Type = " + t.getTypeOfAccommodation() + "\t price = "
										+ t.getHprice() + "\nAminities = " + t.getAmminitiesName()
										+ "\n--------------------------------------------------------------------------------------------------------------------------------------------"));

								// Add delete functionality
								System.out.println("Enter Hotel ID to delete (or press '0' to skip): ");
								int hotelIdToDelete = sc.nextInt();
								if (hotelIdToDelete != 0) {
									boolean deleted = hs.deleteHotel(hotelIdToDelete,lid);
									if (deleted) {
										System.out.println(
												"Hotel with ID " + hotelIdToDelete + " has been deleted successfully.");
									} else {
										System.out.println("Hotel id is not found");
									}
								}
							} else {
								System.out.println("There are no hotels.");
							}
						} else {
							System.out.println("City not found.");
						}
					} else {
						System.out.println("Associated district has no cities.");
					}
				} else {
					System.out.println("District not found.");
				}
			} else {
				System.out.println("Associated state has no districts.");
			}
		} else {
			System.err.println("You entered an incorrect state name.");
		}
	}
	
	
	private void updateHotel() {
		List<StateEntity> al = new ArrayList<StateEntity>();
		al = iStateServices.getAllStates();
		System.out.println("*****************STATES********************");
		System.out.println("State_id\t State_Name");
		al.forEach((t) -> System.out.println(t.getS_id() + "\t\t" + t.getS_name()));

		System.out.println("Enter the state to see Districts");
		String statename = sc.nextLine();
		int stateId = iStateServices.getSatteIdByName(statename);
		if (stateId != 0) {
			List<DistrictEntity> dist = districtService.showAllDistrcitWhitState(stateId);
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

					List<CityEntity> cities = cs.showAllCities(ce);
					if (cities.size() != 0) {
						System.out.println("***************Cities****************");
						System.out.println("city_id \t city_Name");
						cities.forEach((t) -> System.out.println(t.getCityId() + "\t\t" + t.getCityName()));

						System.out.println("Enter city name to see hotels");
						String cityNamw = sc.nextLine();
						ce.setCityName(cityNamw);
						int cityId = cs.getCityIdByName(ce);
						ce.setS_id(stateId);
						ce.setDistId(distId);
						ce.setCityId(cityId);
						if (cityId != 0) {
							int lid = hs.getLocationId(ce);
							List<HotelEntity> hotels = hs.showAllHotel(lid);
							if (hotels.size() != 0) {
								System.out.println(
										"******************************Hotels*****************************************");
								System.out.println("");
								hotels.forEach((t) -> System.out.println("Id = "+t.getHid() + "\t Hotel Name=" + t.getHname() + "\t Address = "
										+ t.getHaddress() + "\t  Type = " + t.getTypeOfAccommodation() + "\t price = "
										+ t.getHprice() + "\nAminities = " + t.getAmminitiesName()
										+ "\n--------------------------------------------------------------------------------------------------------------------------------------------"));

								// Add delete functionality
								System.out.println("Enter the hotel Id to Update hotel");
								int hid=sc.nextInt();
								sc.nextLine();
								if (hs.checkPresence(hid, lid)) {
									int choice=0;
									do {
										System.out.println("what do you want to update");
										System.out.println("1)Hotel name");
										System.out.println("2)Hotel Conatct Number");
										System.out.println("3)Hotel Price");
										System.out.println("4)Exit");
										System.out.println("Enter you choice");
										choice=sc.nextInt();
										sc.nextLine();
										switch (choice) {
										case 1:
											System.out.println("Enter the new name of hotel");
											String newHotel=sc.nextLine();
											if (hs.updateHotelName(newHotel, hid)) {
												System.out.println("Name is updated");
											} else {
												System.out.println("Name is not updated");
											}
											break;
										case 2:
											System.out.println("Enter the new contact number of hotel ");
											String newContact=sc.nextLine();
											if (hs.updateHotelContatc(newContact, hid)) {
												System.out.println("Conatct number is updated");
											} else {
												System.out.println("conatct number is not updated");
											}
											break;
										case 3:
											System.out.println("Enter the new price to changes");
											int newPrice=sc.nextInt();
											sc.nextLine();
											if (hs.updateHotelPrice(newPrice, hid)) {
												System.out.println("Price is updated...");
											} else {
												System.out.println("Price is not updated....");
											}
											break;
										case 4:
											
											break;
										default:
											System.out.println("enter the valid operation");
											break;
										}
									} while (choice!=4);
								} else {
									System.out.println("you enter the wrong Id");
								}
							} else {
								System.out.println("There are no hotels.");
							}
						} else {
							System.out.println("City not found.");
						}
					} else {
						System.out.println("Associated district has no cities.");
					}
				} else {
					System.out.println("District not found.");
				}
			} else {
				System.out.println("Associated state has no districts.");
			}
		} else {
			System.err.println("You entered an incorrect state name.");
		}
	}

}
