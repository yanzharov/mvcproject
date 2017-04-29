package com.epam.apartmentbooking.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.epam.apartmentbooking.beans.User;

@Component
public class GetUserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user=new User();
		user.setId(rs.getInt(1));
		user.setFirstname(rs.getString(2));
		user.setLastname(rs.getString(3));
		user.setGender(rs.getString(4));
		user.setEmail(rs.getString(5));
		user.setPhone(rs.getString(6));
		user.setAdress(rs.getString(7));
		user.setDescription(rs.getString(8));
		user.setRole(rs.getString(9));
		return user;
	}

}
