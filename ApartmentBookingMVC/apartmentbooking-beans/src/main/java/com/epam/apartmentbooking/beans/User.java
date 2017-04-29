package com.epam.apartmentbooking.beans;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private String phone;
	private String adress;
	private String description;
	private String role;
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		
		User other = (User) obj;
		
		if (adress == null) {
			
			if (other.adress != null)
				return false;
			
		} 
		else if (!adress.equals(other.adress))
			return false;
		
		if (description == null) {
			
			if (other.description != null)
				return false;
			
		} 
		else if (!description.equals(other.description))
			return false;
		
		if (email == null) {
			
			if (other.email != null)
				return false;
			
		} 
		else if (!email.equals(other.email))
			return false;
		
		if (firstname == null) {
			
			if (other.firstname != null)
				return false;
			
		} 
		else if (!firstname.equals(other.firstname))
			return false;
		
		if (gender == null) {
			
			if (other.gender != null)
				return false;
			
		} 
		else if (!gender.equals(other.gender))
			return false;
		
		if (id != other.id)
			return false;
		
		if (lastname == null) {
			
			if (other.lastname != null)
				return false;
			
		} 
		else if (!lastname.equals(other.lastname))
			return false;
		
		if (phone == null) {
			
			if (other.phone != null)
				return false;
			
		} 
		else if (!phone.equals(other.phone))
			return false;
		
		if (role == null) {
			
			if (other.role != null)
				return false;
			
		} 
		else if (!role.equals(other.role))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", adress=" + adress
				+ ", description=" + description + ", role=" + role + "]";
	}

}
