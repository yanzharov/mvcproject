package com.epam.apartmentbooking.dao;

import java.util.List;

import com.epam.apartmentbooking.beans.User;
import com.epam.apartmentbooking.dao.exception.DAOException;

public interface UserDAO {
    
	public void addUser(User user,int password) throws DAOException;
	public User signIn(String email,int password) throws DAOException;
	public void changePassword(String email,int password) throws DAOException;
	public void checkUser(String email,int password) throws DAOException;
    public void editUser(User user) throws DAOException;
	
}
