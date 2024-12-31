package com.hotel.client.service;

import java.util.List;

import com.hotel.client.entity.LoginEntity;
import com.hotel.client.repo.ILoginRepo;
import com.hotel.client.repo.LoginRepoImpl;

public class LoginServiceImpl implements ILoginService {
private ILoginRepo iLoginRepo=new LoginRepoImpl();
	@Override
	public boolean isAddNewUser(LoginEntity entity) {
		
		return iLoginRepo.isAddNewUser(entity);
	}
	@Override
	public LoginEntity checkType(LoginEntity le) {
		return iLoginRepo.checkType(le);
	}
	@Override
	public List<LoginEntity> showAllUser(LoginEntity le) {
		// TODO Auto-generated method stub
		return iLoginRepo.showAllUser(le);
	}
	@Override
	public boolean blockUser(String name, String email) {
		// TODO Auto-generated method stub
		return iLoginRepo.blockUser(name, email);
	}
	@Override
	public boolean unBlockUser(String name, String email) {
		// TODO Auto-generated method stub
		return iLoginRepo.unBlockUser(name, email);
	}
	@Override
	public List<LoginEntity> showBlockUser(LoginEntity le) {
		// TODO Auto-generated method stub
		return iLoginRepo.showBlockUser(le);
	}
	@Override
	public List<LoginEntity> showOpenkUser(LoginEntity le) {
		// TODO Auto-generated method stub
		return iLoginRepo.showOpenkUser(le);
	}
	@Override
	public List<LoginEntity> searchkUser(String name) {
		// TODO Auto-generated method stub
		return iLoginRepo.searchkUser(name);
	}


}