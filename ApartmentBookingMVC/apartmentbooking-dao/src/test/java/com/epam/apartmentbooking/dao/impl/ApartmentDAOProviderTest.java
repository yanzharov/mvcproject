package com.epam.apartmentbooking.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springtest.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,DbUnitTestExecutionListener.class })
public class ApartmentDAOProviderTest {
	private final static String CATCH_AN_EXCEPTION="Catch an exception";
    private final static String NAME="Brownstone Studio";
    private final static String APARTMENT="Apartment";
	@Autowired
	private ApartmentDAO apartmentDAO;
	
	@Test
	@DatabaseSetup("classpath:apartments.xml")
	public void testGetApartments() {
		List<Apartment> apartments=null;
		
		try {
			apartments=apartmentDAO.getApartments();
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(2,apartments.size());
	}

	@Test
	@DatabaseSetup("classpath:apartments.xml")
	public void testGetApartmentByName() {
        Apartment apartment=null;
		
		try {
			apartment=apartmentDAO.getApartmentByName(NAME);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(APARTMENT,apartment.getPropertyType());
	}
	
	@Test
	@DatabaseSetup("classpath:apartments.xml")
	public void testGetFilteredApartments() {
		List<Apartment> apartments=null;
		LocalDate startDate=LocalDate.of(2017, 1, 25);
		LocalDate endDate=LocalDate.of(2017, 1, 26);
		Integer price=12000;
		Integer guests=3;
		
		try {
			apartments=apartmentDAO.getFilteredApartments(Date.valueOf(startDate),Date.valueOf(endDate),price,guests);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(1,apartments.size());
	}

}
