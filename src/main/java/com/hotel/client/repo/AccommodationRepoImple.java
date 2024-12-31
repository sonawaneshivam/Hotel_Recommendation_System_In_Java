package com.hotel.client.repo;

import java.util.ArrayList;
import java.util.List;

import com.hotel.client.config.Database_Connection;
import com.hotel.client.entity.AccommodationEntity;

public class AccommodationRepoImple extends Database_Connection implements IAccommodationRepo {

	@Override
	public boolean addAccommodation(AccommodationEntity accommodation) {
		String SQL = "INSERT INTO accommodation VALUES(null,?)";
		try {
			pst = con.prepareStatement(SQL);
			pst.setString(1, accommodation.getTypeOfAccommodation());
			int value = pst.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("AccommodationRepoImple.addAccommodation()");
			System.out.println("Problem in Accommodation Repo Imple" + e.getMessage());
			return false;
		}
	}

	@Override
	public List<AccommodationEntity> showAccommodation() {
		final String SQL = "SELECT * FROM accommodation order by a_id";
		List<AccommodationEntity> accommodations = new ArrayList<>();

		try {
			pst = con.prepareStatement(SQL);
			rs = pst.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("a_id");
				String type = rs.getString("a_type");
				accommodations.add(new AccommodationEntity(id, type));
			}

		} catch (Exception e) {
			System.out.println("AccommodationRepoImpl.showAccommodation() - Error");
			System.out.println(e.getMessage());
		}

		return accommodations;
	}

	@Override
	public boolean updateAccommodation(AccommodationEntity accommodationEntity) {
		final String SQL = "UPDATE accommodation SET a_type = ? WHERE a_id = ?";
		try {
			pst = con.prepareStatement(SQL);
			pst.setString(1, accommodationEntity.getTypeOfAccommodation());
			pst.setInt(2, accommodationEntity.getAccommodationID());

			int rowsUpdated = pst.executeUpdate();
			return rowsUpdated > 0;
		} catch (Exception e) {
			System.out.println("AccommodationRepoImple.updateAccommodation() - Error");
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteAccommodation(int id) {
		final String SQL = "DELETE FROM accommodation WHERE a_id = ?";
		try {
			pst = con.prepareStatement(SQL);
			pst.setInt(1, id);

			int rowsDeleted = pst.executeUpdate();
			return rowsDeleted > 0;
		} catch (Exception e) {
			System.out.println("AccommodationRepoImple.deleteAccommodation() - Error");
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<AccommodationEntity> serch(String name) {
		try {
			pst=con.prepareStatement("select * from accommodation where a_name like ?");
			pst.setString(1,"%" +name+"%");
			rs=pst.executeQuery();
			List<AccommodationEntity> al=new ArrayList<AccommodationEntity>();
			while (rs.next()) {
				al.add(new AccommodationEntity(rs.getInt(1),rs.getString(2)));
			}
			return al;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean check(int a) {
		try {
			pst=con.prepareStatement("select * from  accommodation where a_id=?");
			pst.setInt(1, a);
			rs=pst.executeQuery();
			boolean b=false;
			while (rs.next()) {
				b=true;
			}
			return b;
		} catch (Exception e) {
			System.out.println();
			return false;
		}
	}

}
