package com.epam.apartmentbooking.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.epam.apartmentbooking.beans.Apartment;

@Component
public class GetApartmentMapper implements RowMapper<Apartment>{

	@Override
	public Apartment mapRow(ResultSet rs, int arg1) throws SQLException {
		Apartment apartment=new Apartment();
		apartment.setId(rs.getInt(1));
		apartment.setName(rs.getString(2));
		apartment.setAdress(rs.getString(3));
		apartment.setGuests(rs.getInt(4));
		apartment.setBathrooms(rs.getInt(5));
		apartment.setBedrooms(rs.getInt(6));
		apartment.setBeds(rs.getInt(7));
		apartment.setPropertyType(rs.getString(8));
		apartment.setRoomType(rs.getString(9));
		apartment.setCleaningFee(rs.getInt(10));
		apartment.setSecurityDeposit(rs.getInt(11));
		apartment.setWeeklyDiscount(rs.getInt(12));
		apartment.setCancellation(rs.getString(13));
		apartment.setDescription(rs.getString(14));
		apartment.setOwnerId(rs.getInt(15));
		apartment.setPrice(rs.getInt(16));
		return apartment;
	}

}
