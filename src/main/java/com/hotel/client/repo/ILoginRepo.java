package com.hotel.client.repo;

import java.util.List;

import com.hotel.client.entity.LoginEntity;

public interface ILoginRepo {
	public boolean isAddNewUser(LoginEntity le);
	public LoginEntity checkType(LoginEntity le);
	
	public List<LoginEntity> showAllUser(LoginEntity le);
	
	public boolean blockUser(String name,String email);
	public boolean unBlockUser(String name,String email);
	public List<LoginEntity> showBlockUser(LoginEntity le);
	public List<LoginEntity> showOpenkUser(LoginEntity le);
	public List<LoginEntity> searchkUser(String name);
	
}
