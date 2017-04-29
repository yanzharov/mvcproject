package com.epam.apartmentbooking.service;

import java.sql.Date;
import java.util.List;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.service.exception.ServiceException;

public interface ApartmentService {
	
	public List<Apartment> getApartments() throws ServiceException;
	public Apartment getApartmentByName(String name) throws ServiceException;
	public List<Apartment> getFilteredApartments(Date startDate,Date endDate,Integer price,Integer guests) throws ServiceException;
	
}
