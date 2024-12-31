package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.LoginEntity;

public interface ILoginService {
	public boolean isAddNewUser(LoginEntity entity);
	public LoginEntity checkType(LoginEntity le);
	
	public List<LoginEntity> showAllUser(LoginEntity le);
	public boolean blockUser(String name,String email);
	public boolean unBlockUser(String name,String email);
	public List<LoginEntity> showBlockUser(LoginEntity le);
	public List<LoginEntity> showOpenkUser(LoginEntity le);
	public List<LoginEntity> searchkUser(String name);
}