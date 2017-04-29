package com.epam.apartmentbooking.beans;

import java.io.Serializable;

public class HouseRule implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int apartmentId;
	
	public HouseRule() {

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

	public int getApartmentId() {
		return apartmentId;
	}

	public void setApartmentId(int apartmentId) {
		this.apartmentId = apartmentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + apartmentId;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		
		HouseRule other = (HouseRule) obj;
		
		if (apartmentId != other.apartmentId)
			return false;
		
		if (id != other.id)
			return false;
		
		if (name == null) {
			
			if (other.name != null)
				return false;
			
		} 
		else if (!name.equals(other.name))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "HouseRule [id=" + id + ", name=" + name + ", apartmentId=" + apartmentId + "]";
	}
	
}
