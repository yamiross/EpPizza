package com.epam.pizza.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA_ORDER")
public class Order {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Integer id;
	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@ManyToMany
	@JoinTable(name="ORDERED_PIZZA",
			joinColumns={@JoinColumn(name="ORDER_ID")},
			inverseJoinColumns={@JoinColumn(name="PIZZA_ID")})
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
