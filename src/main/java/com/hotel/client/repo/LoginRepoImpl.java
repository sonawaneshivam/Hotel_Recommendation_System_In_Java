package com.hotel.client.repo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.LoginEntity;

public class LoginRepoImpl extends Database_Connection implements ILoginRepo {

	@Override
	public boolean isAddNewUser(LoginEntity le) {

		String SQL = "insert into user values(0,?,?,?,?,?,'User','open')";
		try {
			pst = con.prepareStatement(SQL);
			pst.setString(1,le.getName());
			pst.setString(2,le.getEmail());
			pst.setString(3,le.getConatct_no());
			pst.setString(4, le.getUsername());
			pst.setString(5, le.getPassword());
			int value=pst.executeUpdate();
			return value>0?true:false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public LoginEntity checkType(LoginEntity le) {
		try {
			pst=con.prepareStatement("select Name,userType,status from user where username=? and password=?");
			pst.setString(1, le.getUsername());
			pst.setString(2, le.getPassword());
			rs=pst.executeQuery();
			String type="";
			String name="";
			String status="";
			while (rs.next()) {
				name=rs.getString(1);
				type=rs.getString(2);
				status=rs.getString(3);
				
			}
			LoginEntity le1=new LoginEntity();
			le1.setType(type);
			le1.setName(name);
			le1.setStatus(status);
			return le1;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<LoginEntity> showAllUser(LoginEntity le) {
		try {
			pst=con.prepareStatement("select loginId,name,email,contactNumber,status from user where usertype='user'");
			rs=pst.executeQuery();
			List<LoginEntity> al=new ArrayList<LoginEntity>();
			while (rs.next()) {
				LoginEntity l = new LoginEntity();
		        l.setId(rs.getInt("loginId"));
		        l.setName(rs.getString("name"));
		        l.setEmail(rs.getString("email"));
		        l.setConatct_no(rs.getString("contactNumber"));
		        l.setStatus(rs.getString("status"));

		        al.add(l);
			}
			return al;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public boolean blockUser(String name, String email) {
		try {
			pst=con.prepareStatement("update user set status='block' where name=? and email=?");
			pst.setString(1, name);
			pst.setString(2, email);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean unBlockUser(String name, String email) {
		try {
			pst=con.prepareStatement("update user set status='open' where name=? and email=?");
			pst.setString(1, name);
			pst.setString(2, email);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<LoginEntity> showBlockUser(LoginEntity le) {
		try {
			pst=con.prepareStatement("select loginId,name,email,contactNumber,status from user where usertype='user' and status='block'");
			rs=pst.executeQuery();
			List<LoginEntity> al=new ArrayList<LoginEntity>();
			while (rs.next()) {
				LoginEntity l = new LoginEntity();
		        l.setId(rs.getInt("loginId"));
		        l.setName(rs.getString("name"));
		        l.setEmail(rs.getString("email"));
		        l.setConatct_no(rs.getString("contactNumber"));
		        l.setStatus(rs.getString("status"));

		        al.add(l);
			}
			return al;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public List<LoginEntity> showOpenkUser(LoginEntity le) {
		try {
			pst=con.prepareStatement("select loginId,name,email,contactNumber,status from user where usertype='user' and status='open'");
			rs=pst.executeQuery();
			List<LoginEntity> al=new ArrayList<LoginEntity>();
			while (rs.next()) {
				LoginEntity l = new LoginEntity();
		        l.setId(rs.getInt("loginId"));
		        l.setName(rs.getString("name"));
		        l.setEmail(rs.getString("email"));
		        l.setConatct_no(rs.getString("contactNumber"));
		        l.setStatus(rs.getString("status"));

		        al.add(l);
			}
			return al;
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public List<LoginEntity> searchkUser(String name) {
		try {
			pst=con.prepareStatement("select loginId,name,email,contactNumber,status from user where usertype='user' and name like ?");
			pst.setString(1, "%"+name+"%");
			rs=pst.executeQuery();
			List<LoginEntity> al=new ArrayList<LoginEntity>();
			while (rs.next()) {
				LoginEntity l = new LoginEntity();
		        l.setId(rs.getInt("loginId"));
		        l.setName(rs.getString("name"));
		        l.setEmail(rs.getString("email"));
		        l.setConatct_no(rs.getString("contactNumber"));
		        l.setStatus(rs.getString("status"));

		        al.add(l);
			}
			return al;
		} catch (Exception e) {
			
			return null;
		}
	}

	
}