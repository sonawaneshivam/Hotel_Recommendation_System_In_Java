package com.hotel.client.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.CityEntity;

public class CityRepoImple extends Database_Connection implements ICityRepo {

	@Override
	public int getCityIdByName(CityEntity ce) {
		try {
			pst=con.prepareStatement("select c_id from cities where c_name=?");
			pst.setString(1, ce.getCityName());
			int cityId=0;
			rs=pst.executeQuery();
			while (rs.next()) {
				cityId=rs.getInt(1);
			}
			return cityId;
		} catch (Exception e) {
			System.out.println("somthing is not working");
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public boolean insertDataWithProcedure(CityEntity ce) {
		try {
			cst=con.prepareCall("{call savecity(?,?,?)}");
			cst.setString(1, ce.getCityName());
			cst.setInt(2, ce.getS_id());
			cst.setInt(3, ce.getDistId());
			boolean b=cst.execute();
			return !b;
		} catch (Exception e) {
			System.out.println("procedure is not working");
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean checkPrsentOrNot(CityEntity ce) {
		try {
			pst=con.prepareStatement("select * from s_d_c_join where s_id=? and d_id=? and c_id=?");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setInt(3, ce.getCityId());
			rs=pst.executeQuery();
			boolean b=true;
			while (rs.next()) {
				b=false;
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean filledInJoin(CityEntity ce) {
		try {
			pst=con.prepareStatement("insert into s_d_c_join values(?,?,?,0)");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setInt(3, ce.getCityId());
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<CityEntity> showAllCities(CityEntity ce) {
		try {
			pst=con.prepareStatement(" select c.c_id,c.c_name from cities  c inner join s_d_c_join sdc on c.c_id =sdc.c_id where s_id=? and d_id=?");
			List<CityEntity> al=new ArrayList<CityEntity>();
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			rs=pst.executeQuery();
			while (rs.next()) {
				al.add(new CityEntity(rs.getInt(1),rs.getString(2)));
			}
			return al;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public int getCount(CityEntity ce) {
		try {
			pst=con.prepareStatement("select count(c_id) from s_d_c_join where s_id=? and d_id=? and c_id=?");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setInt(3, ce.getCityId());
			rs=pst.executeQuery();
			int count=0;
			while (rs.next()) {
				count=rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public boolean updateJoin(CityEntity ce,int newId) {
		try {
			pst=con.prepareStatement(" update  s_d_c_join set c_id = ? where s_id=? and d_id=? and c_id=?");
			pst.setInt(1, newId);
			pst.setInt(2, ce.getS_id());
			pst.setInt(3, ce.getDistId());
			pst.setInt(4, ce.getCityId());
			int value =pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean insertDataInCity(String city) {
		try {
			pst=con.prepareStatement("insert into cities values(0,?)");
			pst.setString(1, city);
			int value =pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delteCity(CityEntity ce) {
		try {
			pst=con.prepareStatement("delete from s_d_c_join where s_id=? and d_id=? and c_id=?");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setInt(3, ce.getCityId());
			int value =pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<CityEntity> serchCity(CityEntity ce) {
		try {
			pst=con.prepareStatement("select c.c_id,c.c_name from cities c inner join s_d_c_join sdc on c.c_id=sdc.c_id where s_id=? and d_id=? and c.c_name like ?");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setString(3, "%"+ce.getCityName()+"%");
			List<CityEntity> al=new ArrayList<CityEntity>();
			rs=pst.executeQuery();
			while (rs.next()) {
				al.add(new CityEntity(rs.getInt(1),rs.getString(2)));
			}
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
