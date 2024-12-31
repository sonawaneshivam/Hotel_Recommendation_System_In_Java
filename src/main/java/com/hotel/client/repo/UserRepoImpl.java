package com.hotel.client.repo;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.LoginEntity;

public class UserRepoImpl extends Database_Connection implements IUserRepo {

	@Override
	public LoginEntity viewProfile(String pass) {
		try {
			pst=con.prepareStatement("select name,email,contactNumber from user where password=?");
			pst.setString(1, pass);
			rs=pst.executeQuery();
			LoginEntity l = new LoginEntity();
			while (rs.next()) { 
		        l.setName(rs.getString("name"));
		        l.setEmail(rs.getString("email"));
		        l.setConatct_no(rs.getString("contactNumber"));	
			}
			return l;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public boolean updateName( String n,String pass) {
		try {
			pst=con.prepareStatement("update user set name=? where  password=?");
			pst.setString(1, n);
			pst.setString(2, pass);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateEmail(String e, String pass) {
		try {
			pst=con.prepareStatement("update user set email=? where  password=?");
			pst.setString(1, e);
			pst.setString(2, pass);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean updateContact(String contact, String pass) {
		try {
			pst=con.prepareStatement("update user set contactNumber=? where  password=?");
			pst.setString(1, contact);
			pst.setString(2, pass);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
		
	}

}
