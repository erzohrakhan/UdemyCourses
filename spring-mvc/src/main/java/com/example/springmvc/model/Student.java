package com.example.springmvc.model;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favouritelanguage;
	private String[] operatingsystem;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFavouritelanguage() {
		return favouritelanguage;
	}

	public void setFavouritelanguage(String favouritelanguage) {
		this.favouritelanguage = favouritelanguage;
	}

	public String[] getOperatingsystem() {
		return operatingsystem;
	}

	public void setOperatingsystem(String[] operatingsystem) {
		this.operatingsystem = operatingsystem;
	}
}
