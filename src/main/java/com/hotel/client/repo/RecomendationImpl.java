package com.hotel.client.repo;

import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.RecomendationEntity;

public class RecomendationImpl extends Database_Connection implements IRecomendation{
/**
 * cfbfbfgdf
 */
	@Override
	public List<RecomendationEntity> showAllHotelWithoutAcc(int lid, int amid) {
		try {
			pst = con.prepareStatement(
					" select h.h_id,h.h_name,h.h_address,ac.a_type,GROUP_CONCAT(a.am_name ORDER BY a.am_name) AS aminities,(h.price + IFNULL(SUM(a.am_price), 0)) AS total_price from hotel h INNER JOIN accommodation ac ON ac.a_id = h.type left join hotel_aminity_join ha ON h.h_id = ha.h_id left join  aminities a ON ha.am_id = a.am_id where h.l_id = ? and a_id!=? group by h.\r\n"
					+ "h_id, h.h_name, h.h_address, ac.a_type, h.price ");
			pst.setInt(1, lid);
			pst.setInt(2, amid);
			
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

	@Override
	public List<RecomendationEntity> showAllHotelWithoutrange(int lid, int amid) {
		try {
			pst = con.prepareStatement(
					" select h.h_id,h.h_name,h.h_address,ac.a_type,GROUP_CONCAT(a.am_name ORDER BY a.am_name) AS aminities,(h.price + IFNULL(SUM(a.am_price), 0)) AS total_price from hotel h INNER JOIN accommodation ac ON ac.a_id = h.type left join hotel_aminity_join ha ON h.h_id = ha.h_id left join  aminities a ON ha.am_id = a.am_id where h.l_id = ? and a_id=? group by h.\r\n"
					+ "h_id, h.h_name, h.h_address, ac.a_type, h.price ");
			pst.setInt(1, lid);
			pst.setInt(2, amid);
			
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
