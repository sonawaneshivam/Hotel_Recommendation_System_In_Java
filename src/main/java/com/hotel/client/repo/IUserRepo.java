package com.hotel.client.repo;

import com.hotel.client.entity.LoginEntity;

public interface IUserRepo {
	
	public LoginEntity viewProfile(String pass);
	public boolean updateName(String n,String pass);
	public boolean updateEmail(String e,String pass);
	public boolean updateContact(String contact,String pass);
}
