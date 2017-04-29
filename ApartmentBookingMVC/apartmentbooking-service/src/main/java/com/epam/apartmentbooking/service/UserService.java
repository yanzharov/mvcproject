package com.epam.apartmentbooking.service;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.service.exception.ServiceException;

public interface UserService {
	
	public void addUser(User user,char[] password) throws ServiceException;
	public User signIn(String email,char[] password) throws ServiceException;
	public void changePassword(String email,char[] oldPassword,char[] newPassword) throws ServiceException;
	public void restorePassword(String email,char[] password) throws ServiceException;
    public void editUser(User user) throws ServiceException;
    
}
