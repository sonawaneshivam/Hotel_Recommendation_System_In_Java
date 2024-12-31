package com.hotel.client.AdminOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hotel.client.config.ClassAndObject;
import com.hotel.client.entity.AccommodationEntity;
import com.hotel.client.service.AccommodationServiceImple;
import com.hotel.client.service.IAccommodationService;

public class AccommodationOperation extends ClassAndObject {
	static Scanner sc = new Scanner(System.in);
	static IAccommodationService accommodationService = new AccommodationServiceImple();
	static Logger logger = Logger.getLogger(AccommodationOperation.class);

    // Static block to configure the logger with the properties file
    static {
        try {
            PropertyConfigurator.configure("E:\\workspace\\Core Java\\hotel-recommendatioin\\src\\main\\resources\\log.properties");
            
        } catch (Exception e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }
	public AccommodationOperation() {
		
		int choice=0;
		do {
			System.out.println();
			System.out.println("1) Add Accommodation.");
			System.out.println("2) Show Accommodation.");
			System.out.println("3) Update Accommodation.");
			System.out.println("4) Delete Accommodation.");
			System.out.println("5) Search Accommodation.");
			System.out.println("6) Exit.");

			System.out.println("Enter your choice: ");
			 choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				logger.info("Accommodation added");
				addAccommodation();
				break;
			case 2:
				showAccommodation();
				break;
			case 3:
				logger.info("updated Accommodation successfully...");
				updateAccommodation();
				break;
			case 4:
				logger.info("Deleted Accommodation..");
				deleteAccommodation();
				break;
			case 5:
				serchAccommodation();
				break;
			case 6:
				System.out.println("Exiting...");
				
				break;
			default:
				System.out.println("Invalid Choice!");
				break;
			}
		} while (choice!=6);
	}

	private void addAccommodation() {
		System.out.println("Enter Accommodation Type: ");
		String accommodationType = sc.nextLine();
		AccommodationEntity entity = new AccommodationEntity(null, accommodationType);
		System.out.println(accommodationService.addAccommodation(entity) ? "Accommodation Added Successfully!"
				: "Unable to Add Accommodation");
		
	}

	public static void showAccommodation() {
		System.out.println("********************Accommodarion**************************");
		accommodationService.showAccommodation().forEach((t)->System.out.println(t.getAccommodationID()+"\t"+t.getTypeOfAccommodation()));
	}

	private void updateAccommodation() {
		showAccommodation();
		System.out.println("Enter New Accommodation Type: ");
		String newType = sc.nextLine();
		System.out.println("Enter That ID: ");
		int id = sc.nextInt();
		AccommodationEntity updatedEntity = new AccommodationEntity(id, newType);
		System.out
				.println(accommodationService.updateAccommodation(updatedEntity) ? "Accommodation Updated Successfully!"
						: "Unable to Update Accommodation");
	}

	private void deleteAccommodation() {
		showAccommodation();
		System.out.println("Enter Accommodation ID to Delete: ");
		int id = sc.nextInt();
		System.out.println(accommodationService.deleteAccommodation(id) ? "Accommodation Deleted Successfully!"
				: "Unable to Delete Accommodation");
	}
	
	private void serchAccommodation() {
		showAccommodation();
		System.out.println("Enter the Accommodation name");
		String name=sc.nextLine();
		List<AccommodationEntity> al=new ArrayList<AccommodationEntity>();
		al=accommodationService.serch(name);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getAccommodationID()+"\t"+t.getTypeOfAccommodation()));
		} else {
			System.out.println("data not found");
		}
	}

}
