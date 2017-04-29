package com.epam.apartmentbooking.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.service.ApartmentService;
import com.epam.apartmentbooking.service.exception.ServiceException;

@Service
public class ApartmentServiceProvider implements ApartmentService{
	@Autowired
	private ApartmentDAO apartmentDAO;
	
	@Override
	public List<Apartment> getApartments() throws ServiceException {
		List<Apartment> apartments=null;
		
		try {
			apartments=apartmentDAO.getApartments();
		} 
		catch (DAOException e) {
			throw new ServiceException();
		}
		
		return apartments;
	}

	@Override
	public Apartment getApartmentByName(String name) throws ServiceException {
		Apartment apartment=null;
		
		try {
			apartment=apartmentDAO.getApartmentByName(name);
		} 
		catch (DAOException e) {
			throw new ServiceException();
		}
		
		return apartment;
	}

	@Override
	public List<Apartment> getFilteredApartments(Date startDate, Date endDate, Integer price, Integer guests) throws ServiceException {
        List<Apartment> apartments=null;
		
		try {
			apartments=apartmentDAO.getFilteredApartments(startDate, endDate, price, guests);
		} 
		catch (DAOException e) {
			throw new ServiceException();
		}
		
		return apartments;
	}
    
}
