package com.hotel.client.AdminOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.hotel.client.entity.DistrictEntity;
import com.hotel.client.entity.LoginEntity;
import com.hotel.client.service.LoginServiceImpl;

public class UserOperation {
	static Scanner sc=new Scanner(System.in);
	static LoginServiceImpl le=new LoginServiceImpl();
	static LoginEntity l=new LoginEntity();
	static DistrictEntity de = new DistrictEntity();
	static Logger logger = Logger.getLogger(UserOperation.class);

    // Static block to configure the logger with the properties file
    static {
        try {
            PropertyConfigurator.configure("E:\\workspace\\Core Java\\hotel-recommendatioin\\src\\main\\resources\\log.properties");
           
            
        } catch (Exception e) {
            System.err.println("Failed to configure logger: " + e.getMessage());
        }
    }
	public UserOperation() {
		
		int choice = 0;
		do {
			System.out.println("");
			System.out.println("1)Show all users");
			System.out.println("2)Block user");
			System.out.println("3)Unblock User");
			System.out.println("4)search user");
			System.out.println("5)Exit");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				logger.info("admine see all users");
				showAllUser();
				break;
			case 2:
				logger.info("admine block user");
				blockUser();
				break;
			case 3:
				logger.info("amine unblock the user");
				unBlockUser();
				break;
			case 4:
				searchUser();
				break;
			case 5:
				
				break;

			default:
				System.out.println("Invalid operation.....");
				break;
			}
		} while (choice != 5);

	}
	
	
	private void showAllUser() {
		List<LoginEntity> al=new ArrayList<LoginEntity>();
		al=le.showAllUser(l);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getEmail()+"\t"+t.getConatct_no()+"\t"+t.getStatus()));
		} else {
			System.out.println("user are not found");
		}
	}
	
	private void blockUser() {
		List<LoginEntity> al=new ArrayList<LoginEntity>();
		al=le.showOpenkUser(l);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getEmail()+"\t"+t.getConatct_no()+"\t"+t.getStatus()));
			System.out.println("enter name for block user");
			String name=sc.nextLine();
			System.out.println("enter email to verify");
			String email=sc.nextLine();
			System.out.println(le.blockUser(name, email)?"block user":"incorrect email or name");
		
		} else {
			System.out.println("all users are blocked");
		}
	}
		
	
	private void unBlockUser() {
		List<LoginEntity> al=new ArrayList<LoginEntity>();
		al=le.showBlockUser(l);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getEmail()+"\t"+t.getConatct_no()+"\t"+t.getStatus()));
			System.out.println("enter name for unblock user");
			String name=sc.nextLine();
			System.out.println("enter email to verify");
			String email=sc.nextLine();
			System.out.println(le.unBlockUser(name, email)?"unblock user":"incorrect email or name");
		} else {
			System.out.println("all user are open");
		}
		
	}
	
	private void searchUser() {
		showAllUser();
		System.out.println("enter the name for search users");
		String name=sc.nextLine();
		List<LoginEntity> al=new ArrayList<LoginEntity>();
		al=le.searchkUser(name);
		if (al.size()!=0) {
			al.forEach((t)->System.out.println(t.getId()+"\t"+t.getName()+"\t"+t.getEmail()+"\t"+t.getConatct_no()+"\t"+t.getStatus()));
		} else {
			System.out.println("user are not found");
		}
		
	}
	
}
