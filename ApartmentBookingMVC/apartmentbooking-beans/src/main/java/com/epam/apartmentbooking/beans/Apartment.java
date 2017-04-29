package com.epam.apartmentbooking.beans;

import java.io.Serializable;

public class Apartment implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String adress;
	private int guests;
	private int bathrooms;
	private int bedrooms;
	private int beds;
	private String propertyType;
	private String roomType;
	private int cleaningFee;
	private int securityDeposit;
	private int weeklyDiscount;
	private String cancellation;
	private String description;
	private int ownerId;
	private int price;
	
	public Apartment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public int getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}

	public int getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCleaningFee() {
		return cleaningFee;
	}

	public void setCleaningFee(int cleaningFee) {
		this.cleaningFee = cleaningFee;
	}

	public int getSecurityDeposit() {
		return securityDeposit;
	}

	public void setSecurityDeposit(int securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public int getWeeklyDiscount() {
		return weeklyDiscount;
	}

	public void setWeeklyDiscount(int weeklyDiscount) {
		this.weeklyDiscount = weeklyDiscount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCancellation() {
		return cancellation;
	}

	public void setCancellation(String cancellation) {
		this.cancellation = cancellation;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + bathrooms;
		result = prime * result + bedrooms;
		result = prime * result + beds;
		result = prime * result + ((cancellation == null) ? 0 : cancellation.hashCode());
		result = prime * result + cleaningFee;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + guests;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ownerId;
		result = prime * result + price;
		result = prime * result + ((propertyType == null) ? 0 : propertyType.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result + securityDeposit;
		result = prime * result + weeklyDiscount;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Apartment other = (Apartment) obj;
		
		if (adress == null) {
			
			if (other.adress != null)
				return false;
			
		} 
		else if (!adress.equals(other.adress))
			return false;
		
		if (bathrooms != other.bathrooms)
			return false;
		
		if (bedrooms != other.bedrooms)
			return false;
		
		if (beds != other.beds)
			return false;
		
		if (cancellation == null) {
			
			if (other.cancellation != null)
				return false;
			
		} 
		else if (!cancellation.equals(other.cancellation))
			return false;
		
		if (cleaningFee != other.cleaningFee)
			return false;
		
		if (description == null) {
			
			if (other.description != null)
				return false;
			
		} 
		else if (!description.equals(other.description))
			return false;
		
		if (guests != other.guests)
			return false;
		
		if (id != other.id)
			return false;
		
		if (name == null) {
			
			if (other.name != null)
				return false;
			
		} 
		else if (!name.equals(other.name))
			return false;
		
		if (ownerId != other.ownerId)
			return false;
		
		if (price != other.price)
			return false;
		
		if (propertyType == null) {
			
			if (other.propertyType != null)
				return false;
			
		} 
		else if (!propertyType.equals(other.propertyType))
			return false;
		
		if (roomType == null) {
			
			if (other.roomType != null)
				return false;
			
		} 
		else if (!roomType.equals(other.roomType))
			return false;
		
		if (securityDeposit != other.securityDeposit)
			return false;
		
		if (weeklyDiscount != other.weeklyDiscount)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", name=" + name + ", adress=" + adress + ", guests=" + guests + ", bathrooms="
				+ bathrooms + ", bedrooms=" + bedrooms + ", beds=" + beds + ", propertyType=" + propertyType
				+ ", roomType=" + roomType + ", cleaningFee=" + cleaningFee + ", securityDeposit=" + securityDeposit
				+ ", weeklyDiscount=" + weeklyDiscount + ", cancellation=" + cancellation + ", decription=" + description
				+ ", ownerId=" + ownerId + ", price=" + price + "]";
	}
	
}
