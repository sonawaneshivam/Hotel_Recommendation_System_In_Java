package com.hotel.client.repo;

import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.CityEntity;
import com.hotel.client.entity.HotelEntity;
import com.hotel.client.entity.RecomendationEntity;

public class HotelRepoImpl extends Database_Connection implements IHotelRepo {

	@Override
	public int getLocationId(CityEntity ce) {
		try {
			pst = con.prepareStatement("select l_id from s_d_c_join where s_id=? and d_id=? and c_id=?");
			pst.setInt(1, ce.getS_id());
			pst.setInt(2, ce.getDistId());
			pst.setInt(3, ce.getCityId());
			rs = pst.executeQuery();
			int lid = 0;
			while (rs.next()) {
				lid = rs.getInt(1);
			}
			return lid;
		} catch (Exception e) {
			System.out.println();
			return 0;
		}
	}

	@Override
	public boolean insertIntoHotel(HotelEntity he) {
		try {
			pst = con.prepareStatement("insert into hotel values(0,?,?,?,?,?,?)");
			pst.setString(1, he.getHname());
			pst.setString(2, he.getHconatct());
			pst.setInt(3, he.getLid());
			pst.setString(4, he.getHaddress());
			pst.setInt(5, he.getAccommodationID());
			pst.setInt(6, he.getHprice());
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public int hotelId() {
		try {
			pst = con.prepareStatement("select max(h_id) from hotel");
			rs = pst.executeQuery();
			int hid = 0;
			while (rs.next()) {
				hid = rs.getInt(1);
			}
			return hid;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	@Override
	public boolean insertIntoAminityJoin(int hid, int amid) {
		try {
			pst = con.prepareStatement("insert into  hotel_aminity_join values(?,?)");
			pst.setInt(1, amid);
			pst.setInt(2, hid);
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<HotelEntity> showAllHotel(int l_id) {
		try {
			pst = con.prepareStatement(
					" select h.h_id,h.h_name,h.h_address,ac.a_type,GROUP_CONCAT(a.am_name ORDER BY a.am_name) AS aminities,(h.price + IFNULL(SUM(a.am_price), 0)) AS total_price from hotel h INNER JOIN accommodation ac ON ac.a_id = h.type left join hotel_aminity_join ha ON h.h_id = ha.h_id left join  aminities a ON ha.am_id = a.am_id where h.l_id = ? group by h.h_id, h.h_name, h.h_address, ac.a_type, h.price");
			pst.setInt(1, l_id);
			rs = pst.executeQuery();
			List<HotelEntity> al = new ArrayList<HotelEntity>();
			while (rs.next()) {
				HotelEntity he = new HotelEntity();
				he.setHid(rs.getInt(1));
				he.setHname(rs.getString(2));
				he.setHaddress(rs.getString(3));
				he.setTypeOfAccommodation(rs.getString(4));
				String amenities = rs.getString("aminities");
				if (amenities == null) {
					he.setAmminitiesName("No amenities");
				} else {
					he.setAmminitiesName(amenities);
				}
				he.setHprice(rs.getInt(6));
				al.add(he);

			}
			return al;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<HotelEntity> serchHotel(int l_id, String name) {
		try {
			pst = con.prepareStatement(
					" select h.h_id,h.h_name,h.h_address,ac.a_type,GROUP_CONCAT(a.am_name ORDER BY a.am_name) AS aminities,(h.price + IFNULL(SUM(a.am_price), 0)) AS total_price from hotel h INNER JOIN accommodation ac ON ac.a_id = h.type left join hotel_aminity_join ha ON h.h_id = ha.h_id left join  aminities a ON ha.am_id = a.am_id where h.l_id = ? and h.h_name like ? group by h.h_id, h.h_name, h.h_address, ac.a_type, h.price");
			pst.setInt(1, l_id);
			pst.setString(2, "%" + name + "%");
			rs = pst.executeQuery();
			List<HotelEntity> al = new ArrayList<HotelEntity>();
			while (rs.next()) {
				HotelEntity he = new HotelEntity();
				he.setHid(rs.getInt(1));
				he.setHname(rs.getString(2));
				he.setHaddress(rs.getString(3));
				he.setTypeOfAccommodation(rs.getString(4));
				String amenities = rs.getString("aminities");
				if (amenities == null) {
					he.setAmminitiesName("No amenities");
				} else {
					he.setAmminitiesName(amenities);
				}
				he.setHprice(rs.getInt(6));
				al.add(he);

			}
			return al;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean deleteHotel(int hotelId, int lid) {
		boolean isDeleted = false;
		try {
			pst = con.prepareStatement("DELETE FROM hotel WHERE h_id = ? and l_id=?");
			pst.setInt(1, hotelId);
			pst.setInt(2, lid);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				isDeleted = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isDeleted;
	}

	@Override
	public boolean checkPresence(int hid, int lid) {
		try {
			pst = con.prepareStatement("select * from hotel where h_id = ? and l_id=?");
			pst.setInt(1, hid);
			pst.setInt(2, lid);
			boolean b = false;
			rs = pst.executeQuery();
			while (rs.next()) {
				b = true;
			}
			return b;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateHotelName(String name, int hid) {
		try {
			pst = con.prepareStatement("update hotel set h_name=? where h_id=?");
			pst.setString(1, name);
			pst.setInt(2, hid);
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateHotelContatc(String contact, int hid) {
		try {
			pst = con.prepareStatement("update hotel set h_contact=? where h_id=?");
			pst.setString(1, contact);
			pst.setInt(2, hid);
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateHotelPrice(int price, int hid) {
		try {
			pst = con.prepareStatement("update hotel set price=? where h_id=?");
			pst.setInt(1, price);
			;
			pst.setInt(2, hid);
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public List<RecomendationEntity> showAllHotelWithAcc(int l_id, int am_id,int min,int max) {
		try {
			pst = con.prepareStatement(
					" select h.h_id,h.h_name,h.h_address,ac.a_type,GROUP_CONCAT(a.am_name ORDER BY a.am_name) AS aminities,(h.price + IFNULL(SUM(a.am_price), 0)) AS total_price from hotel h INNER JOIN accommodation ac ON ac.a_id = h.type left join hotel_aminity_join ha ON h.h_id = ha.h_id left join  aminities a ON ha.am_id = a.am_id where h.l_id = ? and a_id=? group by h.\r\n"
					+ "h_id, h.h_name, h.h_address, ac.a_type, h.price having total_price between ? and ?");
			pst.setInt(1, l_id);
			pst.setInt(2, am_id);
			pst.setInt(3, min);
			pst.setInt(4, max);
			rs = pst.executeQuery();
			List<RecomendationEntity> al = new ArrayList<RecomendationEntity>();
			while (rs.next()) {
				RecomendationEntity he = new RecomendationEntity();
				he.setH_id(rs.getInt(1));
				he.setH_name(rs.getString(2));
				he.setH_add(rs.getString(3));
				he.setH_type(rs.getString(4));
				String amenities = rs.getString("aminities");
				if (amenities == null) {
					he.setAminity("No aminities");
				} else {
					he.setAminity(amenities);
				}
				he.setPrice(rs.getDouble(6));
				al.add(he);

			}
			return al;
		} catch (Exception e) {

			System.out.println(e);
			return null;
		}
	}

}

