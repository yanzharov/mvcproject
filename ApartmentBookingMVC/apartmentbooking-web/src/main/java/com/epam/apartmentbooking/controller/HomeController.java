package com.epam.apartmentbooking.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.apartmentbooking.beans.Apartment;
import com.epam.apartmentbooking.dao.ApartmentDAO;
import com.epam.apartmentbooking.service.ApartmentService;
import com.epam.apartmentbooking.service.exception.ServiceException;

@Controller
public class HomeController {
	@Autowired
	private ApartmentService apartmentService;
	
	@RequestMapping(value = "/apartments", method = RequestMethod.GET)
	public String getApartments(ModelMap map) {
		List<Apartment> apartments=null;
		
		try {
			apartments = apartmentService.getApartments();
		} 
		catch (ServiceException e) {
			
		}
		
		map.addAttribute("apartments", apartments);
		
		return "home";
	}
	
	@RequestMapping(value = "/apartment/{name}", method = RequestMethod.GET)
	public String getApartment(@PathVariable String name,ModelMap map) {
		Apartment apartment=null;
		
		try {
			apartment = apartmentService.getApartmentByName(name);
		} 
		catch (ServiceException e) {
			
		}
		
		map.addAttribute("apartment", apartment);
		
		return "home";
	}
	
}
