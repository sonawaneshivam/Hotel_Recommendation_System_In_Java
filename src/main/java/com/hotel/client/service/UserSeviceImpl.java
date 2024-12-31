package com.hotel.client.service;

import com.hotel.client.entity.LoginEntity;
import com.hotel.client.repo.IUserRepo;
import com.hotel.client.repo.UserRepoImpl;

public class UserSeviceImpl implements IUserService {
	static IUserRepo ur=new UserRepoImpl();
	@Override
	public LoginEntity viewProfile(String pass) {
		
		return ur.viewProfile(pass);
	}
	@Override
	public boolean updateName( String n, String pass) {
		// TODO Auto-generated method stub
		return ur.updateName( n, pass);
	}
	@Override
	public boolean updateEmail(String e, String pass) {
		// TODO Auto-generated method stub
		return ur.updateEmail(e, pass);
	}
	@Override
	public boolean updateContact(String contact, String pass) {
		// TODO Auto-generated method stub
		return ur.updateContact(contact, pass);
	}

}
