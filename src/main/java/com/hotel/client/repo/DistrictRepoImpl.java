package com.hotel.client.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.DistrictEntity;

public class DistrictRepoImpl extends Database_Connection implements IDistrictRepo {

	@Override
	public int getDistIdByName(String distname) {
		try {
			pst=con.prepareStatement("select distId from dist where distName=?");
			pst.setString(1, distname);
			rs=pst.executeQuery();
			int distId=0;
			while (rs.next()) {
				distId=rs.getInt(1);
			}
			return distId;
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public boolean distAddedByProcedure(DistrictEntity de) {
		try {
			cst=con.prepareCall("{call savedist(?,?)}");
			cst.setString(1, de.getDistName());
			cst.setInt(2, de.getS_id());
			boolean b=cst.execute();
			return !b;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
	}

	@Override
	public boolean checkDIstrikIsPreset(DistrictEntity de) {
		try {
			pst=con.prepareStatement("select * from state_dist_join where stateId=? and distId=?");
			pst.setInt(1, de.getS_id());
			pst.setInt(2, de.getDistId());
			rs=pst.executeQuery();
			boolean b=true;
			while (rs.next()) {
				b=false;
			}
			return b;
		} catch (Exception e) {
		System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean insertIntoStateDistrict(DistrictEntity de) {
		try {
			pst=con.prepareStatement("insert into state_dist_join values(?,?)");
			pst.setInt(1, de.getS_id());
			pst.setInt(2, de.getDistId());
			int value=pst.executeUpdate();
			return value>0?true:false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<DistrictEntity> showAllDistrcitWhitState(int stateID) {
		try {
			pst=con.prepareStatement("select d.distid d,distname from dist as d inner join state_dist_join as sd on d.distId=sd.distId where stateId=?");
			pst.setInt(1, stateID);
			rs=pst.executeQuery();
			ArrayList<DistrictEntity> al=new ArrayList<DistrictEntity>();
			
			while (rs.next()) {
				al.add(new DistrictEntity(rs.getInt(1), rs.getString(2)));
			}
			return al;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public boolean checkDistrictPrestent(DistrictEntity de) {
		try {
			pst=con.prepareStatement("select * from dist where distName=? ");
			
			pst.setString(1, de.getDistName());
			rs=pst.executeQuery();
			boolean b=false;
			while (rs.next()) {
				b=true;
			}
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean CheckDistricAndStatePresent(DistrictEntity de) {
		try {
			pst=con.prepareStatement("select * from  state_dist_join where stateId=? and distId=? ");
			pst.setInt(1, de.getS_id());
			pst.setInt(2, de.getDistId());
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
	public boolean insertDataInJoin(DistrictEntity de,int old) {
		try {
			pst=con.prepareStatement(" update state_dist_join set distId=? where stateId=? and distId=?");
			pst.setInt(1, de.getDistId());
			pst.setInt(2, de.getS_id());
			pst.setInt(3, old);
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean newDistrict(DistrictEntity de) {
		try {
			pst=con.prepareStatement("insert into dist values(0,?)");
			pst.setString(1, de.getDistName());
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<DistrictEntity> searchDist(DistrictEntity de) {
		try {
			pst=con.prepareStatement("select d.distid d,distname from dist as d inner join state_dist_join as sd on d.distId=sd.distId where sd.stateId =? and d.distname like ?");
			pst.setInt(1, de.getS_id());
			pst.setString(2,"%"+ de.getDistName()+"%");
			List<DistrictEntity> al=new ArrayList<DistrictEntity>();
			rs=pst.executeQuery();
			while (rs.next()) {
				al.add(new DistrictEntity(rs.getInt(1), rs.getString(2)));
				
			}
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public int checkDistCount(DistrictEntity de) {
		try {
			pst=con.prepareStatement("select count(distinct d.distId) from dist as d inner join state_dist_join as sd on d.distId=sd.distId where stateId=?");
			pst.setInt(1, de.getS_id());
			rs=pst.executeQuery();
			int no=0;
			while (rs.next()) {
				no=rs.getInt(1);
			}
			return no;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public boolean delteFromJoin(DistrictEntity de) {
		try {
			pst=con.prepareStatement("delete from state_dist_join where stateId=? and distId=?");
			pst.setInt(1, de.getS_id());
			pst.setInt(2, de.getDistId());
			int value=pst.executeUpdate();
			return value>0?true:false;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteFromTables(DistrictEntity de) {
		try {
			pst=con.prepareStatement("delete from dist where distName=?");
			pst.setString(1,de.getDistName() );
			int value=pst.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	
	

}