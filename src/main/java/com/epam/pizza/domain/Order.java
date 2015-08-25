package com.epam.pizza.domain;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDER")
@NamedQuery(name="findAllByCustomer", query="SELECT o FROM Order o WHERE o.customer.id = :customerId")
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Integer id;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	@Column(name="TOTAL_PRICE")
	private Double price;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(
			name="ORDERED_PIZZA", 
			joinColumns = {@JoinColumn(name="ORDER_ID")})
	@MapKeyJoinColumn(name="PIZZA_ID")
	@Column(name="PIZAA_AMOUNT")
	private Map<Pizza, Integer> pizzas;
	
	public Order() {
	}
	
	public Order(Customer customer, Map<Pizza, Integer> pizzas) {
		super();
		this.pizzas = pizzas;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<Pizza, Integer> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Map<Pizza, Integer> pizzas) {
		this.pizzas = pizzas;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", address="
				+ address + ", pizzas=" + pizzas + ", price=" + price + "]";
	}
}
