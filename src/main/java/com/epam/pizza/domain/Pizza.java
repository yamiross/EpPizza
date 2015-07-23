package com.epam.pizza.domain;

public class Pizza {

	private Integer id;
	private String pizzaName;
	private Double price;
	private PizzaType type;
	
	public Pizza() {
	}

	public Pizza(Integer id, String pizzaName, Double price, PizzaType type) {
		super();
		this.id = id;
		this.pizzaName = pizzaName;
		this.price = price;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return pizzaName;
	}

	public void setName(String name) {
		this.pizzaName = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public PizzaType getType() {
		return type;
	}

	public void setType(PizzaType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", pizzaName=" + pizzaName + ", price="
				+ price + ", type=" + type + "]";
	}
}
