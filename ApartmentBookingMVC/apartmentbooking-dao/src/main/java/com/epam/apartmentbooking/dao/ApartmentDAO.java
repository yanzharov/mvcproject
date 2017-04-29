package com.epam.apartmentbooking.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.exception.DAOException;

public interface ApartmentDAO {
	
	public List<Apartment> getApartments() throws DAOException;
	public Apartment getApartmentByName(String name) throws DAOException;
	public List<Apartment> getFilteredApartments(Date startDate,Date endDate,Integer price,Integer guests) throws DAOException;
	
}
