package com.epam.apartmentbooking.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.UserDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.dao.util.GetUserMapper;

@Component
public class UserDAOProvider implements UserDAO{
	private static final String ADD_USER="INSERT INTO USERS(FIRSTNAME, LASTNAME, GENDER, EMAIL, PHONE, ADRESS, DESCRIPTION, ROLE, PASSWORD)"
            + " VALUES (:FIRSTNAME, :LASTNAME, :GENDER, :EMAIL, :PHONE, :ADRESS, :DESCRIPTION, :ROLE, :PASSWORD)";
	private final static String SIGN_IN="SELECT ID,FIRSTNAME, LASTNAME, GENDER, EMAIL, PHONE, ADRESS, DESCRIPTION, ROLE FROM USERS"
			+ " WHERE EMAIL=:EMAIL AND PASSWORD=:PASSWORD";
	private final static String CHANGE_PASSWORD="UPDATE USERS SET PASSWORD=:PASSWORD WHERE EMAIL=:EMAIL";
	private final static String CHECK_USER="SELECT ID,FIRSTNAME, LASTNAME, GENDER, EMAIL, PHONE, ADRESS, DESCRIPTION, ROLE FROM USERS"
			+ " WHERE EMAIL=:EMAIL AND PASSWORD=:PASSWORD";
	private static final String EDIT_USER="UPDATE USERS SET FIRSTNAME=:FIRSTNAME,LASTNAME=:LASTNAME,GENDER=:GENDER,EMAIL=:EMAIL,"
			+ "PHONE=:PHONE,ADRESS=:ADRESS,DESCRIPTION=:DESCRIPTION,ROLE=:ROLE WHERE ID=:ID";
	private final static String FIRSTNAME="FIRSTNAME";
	private final static String LASTNAME="LASTNAME";
	private final static String GENDER="GENDER";
	private final static String EMAIL="EMAIL";
	private final static String PHONE="PHONE";
	private final static String ADRESS="ADRESS";
	private final static String DESCRIPTION="DESCRIPTION";
	private final static String ROLE="ROLE";
	private final static String PASSWORD="PASSWORD";
	private final static String ID="ID";
    @Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private GetUserMapper getUserMapper;
	
	@Override
	public void addUser(User user, int password) throws DAOException {
		MapSqlParameterSource source=new MapSqlParameterSource();
		
		source.addValue(FIRSTNAME,user.getFirstname());
		source.addValue(LASTNAME,user.getLastname());
		source.addValue(GENDER,user.getGender());
		source.addValue(EMAIL,user.getEmail());
		source.addValue(PHONE,user.getPhone());
		source.addValue(ADRESS,user.getAdress());
		source.addValue(DESCRIPTION,user.getDescription());
		source.addValue(ROLE,user.getRole());
		source.addValue(PASSWORD,password);

		try{
			jdbcTemplate.update(ADD_USER, source);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
	}

	@Override
	public User signIn(String email, int password) throws DAOException {
		User user=null;
		MapSqlParameterSource source=new MapSqlParameterSource();
		
		source.addValue(EMAIL,email);
		source.addValue(PASSWORD, password);
		
		try{
			user=jdbcTemplate.queryForObject(SIGN_IN, source, getUserMapper);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
		return user;
	}

	@Override
	public void changePassword(String email,int password) throws DAOException {
		MapSqlParameterSource source=new MapSqlParameterSource(); 
		
		source.addValue(PASSWORD, password);
		source.addValue(EMAIL,email);
		
		try{
			jdbcTemplate.update(CHANGE_PASSWORD, source);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
	}

	@Override
	public void checkUser(String email, int password) throws DAOException {
		MapSqlParameterSource source=new MapSqlParameterSource(); 
		
		source.addValue(EMAIL,email);
		source.addValue(PASSWORD, password);
		
		try{
			jdbcTemplate.queryForObject(CHECK_USER, source, getUserMapper);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
	}
	
	@Override
	public void editUser(User user) throws DAOException {
		MapSqlParameterSource source=new MapSqlParameterSource();
		
		source.addValue(FIRSTNAME,user.getFirstname());
		source.addValue(LASTNAME,user.getLastname());
		source.addValue(GENDER,user.getGender());
		source.addValue(EMAIL,user.getEmail());
		source.addValue(PHONE,user.getPhone());
		source.addValue(ADRESS,user.getAdress());
		source.addValue(DESCRIPTION,user.getDescription());
		source.addValue(ROLE,user.getRole());
		source.addValue(ID,user.getId());

		try{
			jdbcTemplate.update(EDIT_USER, source);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
	}
	
}
