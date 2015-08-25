package com.epam.pizza.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="findCustomerByName", query="SELECT c FROM Customer c WHERE c.name = :name")
public class Customer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private Integer id;
	@Column(name="NAME")
	private String name;
	@Column(name="password")
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCUMULATIVE_CARD_ID")
	private AccumulativeCard accumulativeCard;

	public Customer(){}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AccumulativeCard getAccumulativeCard() {
		return accumulativeCard;
	}

	public void setAccumulativeCard(AccumulativeCard accumulativeCard) {
		this.accumulativeCard = accumulativeCard;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accumulativeCard=" + accumulativeCard + "]";
	}
}
