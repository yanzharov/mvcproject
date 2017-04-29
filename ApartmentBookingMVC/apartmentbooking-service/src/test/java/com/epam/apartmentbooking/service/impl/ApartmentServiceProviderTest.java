package com.epam.apartmentbooking.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.service.exception.ServiceException;

@RunWith(MockitoJUnitRunner.class)
public class ApartmentServiceProviderTest {
	private final static String CATCH_AN_EXCEPTION="Catch an exception";
	private final static String NAME="BrownStone Studio";
	@Mock
	private ApartmentDAO apartmentDAO;
	@InjectMocks
	private ApartmentServiceProvider apartmentService;
	
	@Test
	public void testGetApartments() {
		List<Apartment> expectedApartments=new ArrayList<Apartment>();
		List<Apartment> actualApartments=null;
		
		for(int i=0;i<5;i++){
			expectedApartments.add(new Apartment());
		}
		
		try {
			when(apartmentDAO.getApartments()).thenReturn(expectedApartments);
		} 
		catch (DAOException e1) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			actualApartments=apartmentService.getApartments();
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(expectedApartments,actualApartments);
	}

	@Test
	public void testGetApartmentByName() {
		Apartment expectedApartment=new Apartment();
		Apartment actualApartment=null;
		
		expectedApartment.setName(NAME);
		
		try {
			when(apartmentDAO.getApartmentByName(NAME)).thenReturn(expectedApartment);
		} 
		catch (DAOException e1) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			actualApartment=apartmentService.getApartmentByName(NAME);
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(expectedApartment,actualApartment);
	}
	
	@Test
	public void testGetFilteredApartments() {
		List<Apartment> expectedApartments=new ArrayList<Apartment>();
		List<Apartment> actualApartments=null;
		
		LocalDate startDate=LocalDate.of(2017, 1, 25);
		LocalDate endDate=LocalDate.of(2017, 1, 26);
		Integer price=12000;
		Integer guests=3;
		
		for(int i=0;i<5;i++){
			expectedApartments.add(new Apartment());
		}
		
		try {
			when(apartmentDAO.getFilteredApartments(Date.valueOf(startDate),Date.valueOf(endDate),price,guests)).thenReturn(expectedApartments);
		} 
		catch (DAOException e1) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			actualApartments=apartmentService.getFilteredApartments(Date.valueOf(startDate),Date.valueOf(endDate),price,guests);
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(expectedApartments,actualApartments);
	}


}
