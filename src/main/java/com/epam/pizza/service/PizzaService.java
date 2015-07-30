package com.epam.pizza.service;

import java.util.List;

import com.epam.pizza.domain.Pizza;

public interface PizzaService {

	public Pizza getPizzaByID(Integer id);
	public List<Pizza> findAll();
	public void save(Pizza pizza);
}
