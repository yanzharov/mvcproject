package com.epam.apartmentbooking.dao.impl;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.dao.util.GetApartmentMapper;

@Component
public class ApartmentDAOProvider implements ApartmentDAO{
	private static final String GET_APARTMENTS="SELECT ID,NAME,ADRESS,GUESTS,BATHROOMS,BEDROOMS,BEDS,PROPERTY_TYPE,ROOM_TYPE,CLEANING_FEE,"
			+ "SECURITY_DEPOSIT,WEEKLY_DISCOUNT,CANCELLATION,DESCRIPTION,OWNER_ID,PRICE FROM APARTMENTS";
	private static final String GET_APARTMENT_BY_NAME="SELECT ID,NAME,ADRESS,GUESTS,BATHROOMS,BEDROOMS,BEDS,PROPERTY_TYPE,ROOM_TYPE,CLEANING_FEE,"
			+ "SECURITY_DEPOSIT,WEEKLY_DISCOUNT,CANCELLATION,DESCRIPTION,OWNER_ID,PRICE FROM APARTMENTS WHERE NAME=:NAME";
	private static final String GET_FILTERED_APARTMENTS="SELECT APARTMENTS.ID,APARTMENTS.NAME,APARTMENTS.ADRESS,APARTMENTS.GUESTS,APARTMENTS.BATHROOMS,"
			+ "APARTMENTS.BEDROOMS,APARTMENTS.BEDS,APARTMENTS.PROPERTY_TYPE,APARTMENTS.ROOM_TYPE,APARTMENTS.CLEANING_FEE,APARTMENTS.SECURITY_DEPOSIT,"
			+ "APARTMENTS.WEEKLY_DISCOUNT,APARTMENTS.CANCELLATION,APARTMENTS.DESCRIPTION,APARTMENTS.OWNER_ID,APARTMENTS.PRICE FROM APARTMENTS "
			+ "WHERE APARTMENTS.ID NOT IN( SELECT ORDERS.APARTMENT_ID FROM ORDERS WHERE (:START_DATE>ORDERS.START_DATE OR :START_DATE IS NULL) AND (:END_DATE<ORDERS.END_DATE OR :END_DATE IS NULL)) "
			+ "AND (APARTMENTS.PRICE<:PRICE OR :PRICE IS NULL) AND (APARTMENTS.GUESTS>=:GUESTS OR :GUESTS IS NULL)";
	private static final String NAME="NAME";
	private static final String START_DATE="START_DATE";
	private static final String END_DATE="END_DATE";
	private static final String PRICE="PRICE";
	private static final String GUESTS="GUESTS";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	private GetApartmentMapper getApartmentMapper;
	
	@Override
	public List<Apartment> getApartments() throws DAOException {
		List<Apartment> apartments=null;
		
		try{
		    apartments=jdbcTemplate.query(GET_APARTMENTS,getApartmentMapper);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
		return apartments;
	}

	@Override
	public Apartment getApartmentByName(String name) throws DAOException {
		Apartment apartment=null;
		MapSqlParameterSource source=new MapSqlParameterSource(); 
		
		source.addValue(NAME,name);
		
		try{
			apartment=jdbcTemplate.queryForObject(GET_APARTMENT_BY_NAME, source, getApartmentMapper);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
		return apartment;
	}

	@Override
	public List<Apartment> getFilteredApartments(Date startDate,Date endDate,Integer price,Integer guests) throws DAOException {
        List<Apartment> apartments=null;
        MapSqlParameterSource source=new MapSqlParameterSource(); 
		
		source.addValue(START_DATE,startDate);
		source.addValue(END_DATE,endDate);
		source.addValue(PRICE,price);
		source.addValue(GUESTS,guests);
		
		try{
		    apartments=jdbcTemplate.query(GET_FILTERED_APARTMENTS,source,getApartmentMapper);
		}
		catch(DataAccessException e){
			throw new DAOException();
		}
		
		return apartments;
	}

}
