package com.epam.pizzaapp.domain;

import java.util.List;

public class Order {

	private Integer id;
	private Customer customer;
	private List<Pizza> pizzas;
	
	public Order() {
	}
	
	public Order(Customer customer, List<Pizza> pizzas) {
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

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", \ncustomer=" + customer + ", \npizzas="
				+ pizzas + "]";
	}
}
