package com.hotel.client.AdminOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.hotel.client.config.ClassAndObject;
import com.hotel.client.entity.AmminitiesEntity;
import com.hotel.client.service.AmminitiesServiceImple;
import com.hotel.client.service.IAmminitiesService;

public class AmminitiesOperatin extends ClassAndObject {
	static Logger logger = Logger.getLogger(AmminitiesOperatin.class);

    // Static block to configure the logger with the properties file
    static {
        try {
            PropertyConfigurator.configure("E:\\workspace\\Core Java\\hotel-recommendatioin\\src\\main\\resources\\log.properties");
            
        } catch (Exception e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }
	static Scanner scanner = new Scanner(System.in);
	static IAmminitiesService ammnityService = new AmminitiesServiceImple();
	static AmminitiesEntity ae=new AmminitiesEntity();

	public AmminitiesOperatin() {
		int choice=0;
		do {
			System.out.println("1) Add Amminity");
			System.out.println("2) Show Amminity");
			System.out.println("3) Update Amminity");
			System.out.println("4) Delete Amminity");
			System.out.println("5) Search Amminity");
			System.out.println("6) Exit From Amminity Operation");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				logger.info("Add new aminity");
				addAmminity();
				break;

			case 2:
				showAmminities();
				break;

			case 3:
				logger.info("updated aminity successfully...");
				updateAmminity();
				break;

			case 4:
				logger.info("aminity is deleted");
				deleteAmminity();
				break;
			case 5:
				serchAmminity();
				break;
				
			case 6:
				System.out.println("Exiting from Amminity Operations...");
				break;
				

			default:
				System.out.println("Invalid choice! Please select a valid option.");
			}
		} while (choice!=6);
	}

	private void addAmminity() {
		System.out.print("Enter Amminity Name: ");
		String name = scanner.nextLine();

		System.out.println("Amminity Price: ");
		double price = scanner.nextDouble();

		AmminitiesEntity amminitiesEntity = new AmminitiesEntity(null, name, price);

		System.out.println(ammnityService.addAmminity(amminitiesEntity) ? "Amminity added successfully!"
				: "Unable to add amminity.");
	}

	public static void showAmminities() {
		if (ammnityService.showAmmnity().isEmpty()) {
			System.out.println("No Available Amminity!");
		} else {
			System.out.println("**************Amminity**********************");
			ammnityService.showAmmnity().forEach((t)->System.out.println(t.getAminitiesID()+"\t"+t.getAmminitiesName()+"\t"+t.getAmmnitiesPrice()));
		}
	}

	private void updateAmminity() {
		showAmminities();
		System.out.print("Enter Amminity ID to Update: ");
		int updateId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new Amminity: ");
		String amminityName = scanner.nextLine();

		System.out.println("Enter new Price: ");
		double amminityPrice = scanner.nextDouble();

		System.out.println(ammnityService.updateAmminity(new AmminitiesEntity(updateId, amminityName, amminityPrice))
				? "Successfully Updated Record!"
				: "Unable to update Record");
	}

	private void deleteAmminity() {
		showAmminities();
		System.out.println("Enter amminity id to delete: ");
		int deleteID = scanner.nextInt();
		
		System.out.println(ammnityService.deleteAmminity(deleteID)?"Successfully Deleted Record!":"Unable to Delete Record");
	}
	
	private void serchAmminity() {
		showAmminities();
		System.out.println("Enter Amminity to search");
		String name=scanner.nextLine();
		List<AmminitiesEntity> al=new ArrayList<AmminitiesEntity>();
		al=ammnityService.search(name);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getAminitiesID()+"\t"+t.getAmminitiesName()+"\t"+t.getAmmnitiesPrice()));
		}
		else {
			System.out.println("Not found");
		}
		
	}
}
