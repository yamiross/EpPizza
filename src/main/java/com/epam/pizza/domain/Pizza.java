package com.epam.pizza.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA")
@NamedQuery(name="findAll", query="SELECT p FROM Pizza p")
public class Pizza {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PIZZA_ID")
	private Integer id;
	@Column(name="PIZZA_NAME")
	private String pizzaName;
	@Column(name="PRICE")
	private Double price;
	@Enumerated(EnumType.STRING)
	@Column(name="PIZZA_TYPE")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((pizzaName == null) ? 0 : pizzaName.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Pizza other = (Pizza) obj;
		if (pizzaName == null) {
			if (other.pizzaName != null)
				return false;
		} else if (!pizzaName.equals(other.pizzaName))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nPizza [id=" + id + ", pizzaName=" + pizzaName + ", price="
				+ price + ", type=" + type + "]";
	}
}
