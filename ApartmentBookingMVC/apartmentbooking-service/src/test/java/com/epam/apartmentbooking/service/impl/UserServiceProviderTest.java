package com.epam.apartmentbooking.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.UserDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.service.exception.ServiceException;
import com.epam.apartmentbooking.service.util.HashScrambler;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceProviderTest {
	private final static String CATCH_AN_EXCEPTION="Catch an exception";
	private final static String EMAIL="testUser@gmail.com";
	@Mock
	private UserDAO userDAO;
	@Spy
	private HashScrambler hashScrambler;
	@InjectMocks
	private UserServiceProvider userServiceProvider;
	
	@Test
	public void testAddUser() {
		User user=new User();
		
		user.setEmail(EMAIL);
        
		try {
			doNothing().when(userDAO).addUser(user, 530447);
		} 
        catch (DAOException e) {
        	fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			userServiceProvider.addUser(user, "abc".toCharArray());
		}
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			verify(userDAO).addUser(user, 530447);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	public void testSignIn() {
		User expectedUser=new User();
		User actualUser=null;
		
		expectedUser.setEmail(EMAIL);
		
		try {
			when(userDAO.signIn(EMAIL, 530447)).thenReturn(expectedUser);
		} 
		catch (DAOException e1) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			actualUser=userServiceProvider.signIn(EMAIL, "abc".toCharArray());
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(actualUser,expectedUser);	
	}

	@Test
	public void testChangePassword() {
		
		try {
			doNothing().when(userDAO).checkUser(EMAIL, 530447);
			doNothing().when(userDAO).changePassword(EMAIL, 530445);
		} 
        catch (DAOException e) {
        	fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			userServiceProvider.changePassword(EMAIL, "abc".toCharArray(), "aba".toCharArray());
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			verify(userDAO).checkUser(EMAIL, 530447);
			verify(userDAO).changePassword(EMAIL, 530445);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	public void testRestorePassword() {
		
		try {
			doNothing().when(userDAO).changePassword(EMAIL, 530447);
		} 
        catch (DAOException e) {
        	fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			userServiceProvider.restorePassword(EMAIL, "abc".toCharArray());
		} 
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			verify(userDAO).changePassword(EMAIL, 530447);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	public void testEditUser() {
        User user=new User();
		
		user.setEmail(EMAIL);
        user.setId(12);
        
        try {
			doNothing().when(userDAO).editUser(user);
		} 
        catch (DAOException e) {
        	fail(CATCH_AN_EXCEPTION);
		}
        
		try {
			userServiceProvider.editUser(user);
		}
		catch (ServiceException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		try {
			verify(userDAO).editUser(user);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

}
