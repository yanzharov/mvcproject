package com.epam.apartmentbooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.UserDAO;
import com.epam.apartmentbooking.dao.exception.DAOException;
import com.epam.apartmentbooking.service.UserService;
import com.epam.apartmentbooking.service.exception.ServiceException;
import com.epam.apartmentbooking.service.util.HashScrambler;

@Service
public class UserServiceProvider implements UserService{
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private HashScrambler hashScrambler;
	
	@Override
	public void addUser(User user, char[] password) throws ServiceException {
		int hashPassword=hashScrambler.encrypt(password);
		
		try {
			userDAO.addUser(user, hashPassword);
		} 
		catch (DAOException e) {
		    throw new ServiceException();
		}
		
	}

	@Override
	public User signIn(String email, char[] password) throws ServiceException {
        int hashPassword=hashScrambler.encrypt(password);
		User user=null;
		
		try {
			user=userDAO.signIn(email, hashPassword);
		} 
		catch (DAOException e) {
		    throw new ServiceException();
		}
		
		return user;
	}

	@Override
	public void restorePassword(String email, char[] password) throws ServiceException {
        int hashPassword=hashScrambler.encrypt(password);
		
		try {
			userDAO.changePassword(email, hashPassword);
		} 
		catch (DAOException e) {
		    throw new ServiceException();
		}
		
	}

	@Override
	public void editUser(User user) throws ServiceException {

		try {
			userDAO.editUser(user);
		} 
		catch (DAOException e) {
		    throw new ServiceException();
		}
		
	}

	@Override
	public void changePassword(String email, char[] oldPassword, char[] newPassword) throws ServiceException {
        int oldHashPassword=hashScrambler.encrypt(oldPassword);
		int newHashPassword=hashScrambler.encrypt(newPassword);
		
		try {
			userDAO.checkUser(email, oldHashPassword);
		} 
		catch (DAOException e) {
		    throw new ServiceException();
		}
		
		try {
			userDAO.changePassword(email, newHashPassword);
		} 
		catch (DAOException e) {
			throw new ServiceException();
		}
		
	}

}
