package com.epam.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID")
	private Integer id;
	private String city;
	private String street;
	@Column(name="HOUSE_NUMBER")
	private String houseNumber;
	private Integer apt;
	
	public Address() {}
	
	public Address(String city, String street, String houseNumber, Integer apt) {
		super();
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.apt = apt;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getApt() {
		return apt;
	}

	public void setApt(Integer apt) {
		this.apt = apt;
	}

	@Override
	public String toString() {
		return "\nAddress [id=" + id + ", city=" + city + ", street=" + street
				+ ", houseNumber=" + houseNumber + ", apt=" + apt + "]";
	}
}
