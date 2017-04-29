package com.epam.apartmentbooking.dao.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.UserDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springtest.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,DbUnitTestExecutionListener.class })
public class UserDAOProviderTest {
	private final static String ADD_USER_EMAIL="user@gmail.com";
	private final static String SIGN_IN_EMAIL="han_solo@gmaim.com";
	private final static String CHANGE_PASSWORD_EMAIL="han_solo@gmaim.com";
	private final static String CHECK_USER_EMAIL="han_solo@gmaim.com";
	private final static String EDIT_USER_EMAIL="han_solo@gmaim.com";
	private final static String CATCH_AN_EXCEPTION="Catch an exception";
	private final static String ADRESS="New York";
	private final static String DESCRIPTION="I am a singer";
	private final static String FIRSTNAME="Han";
	private final static String LASTNAME="Solo";
	private final static String GENDER="male";
	private final static String PHONE="111111121";
	private final static String ROLE="user";
	@Autowired
	private UserDAO userDAO;

	@Test
	@DatabaseSetup("classpath:signInData.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value="classpath:addUser.xml")
	public void testAddUser() {
		User user=new User();
		
		user.setAdress(ADRESS);
		user.setDescription(DESCRIPTION);
		user.setFirstname(FIRSTNAME);
		user.setLastname(LASTNAME);
		user.setGender(GENDER);
		user.setPhone(PHONE);
		user.setRole(ROLE);
		user.setEmail(ADD_USER_EMAIL);
		
		try {
			userDAO.addUser(user, 422111);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	@DatabaseSetup("classpath:signInData.xml")
	public void testSignIn() {
		User user=null;
		
		try {
			user=userDAO.signIn(SIGN_IN_EMAIL, 422111);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
		assertEquals(FIRSTNAME,user.getFirstname());
	}

	@Test
	@DatabaseSetup("classpath:signInData.xml")
	@ExpectedDatabase(assertionMode=DatabaseAssertionMode.NON_STRICT, value="classpath:changePassword.xml")
	public void testChangePassword() {
		
		try {
			userDAO.changePassword(CHANGE_PASSWORD_EMAIL, 422112);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	@DatabaseSetup("classpath:signInData.xml")
	public void testCheckUser() {
		
		try {
			userDAO.checkUser(CHECK_USER_EMAIL, 422111);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}

	@Test
	@DatabaseSetup("classpath:signInData.xml")
	public void testEditUser() {
        User user=new User();
        
		user.setEmail(EDIT_USER_EMAIL);
		
		try {
			userDAO.editUser(user);
		} 
		catch (DAOException e) {
			fail(CATCH_AN_EXCEPTION);
		}
		
	}
}
