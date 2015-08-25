package com.epam.pizza.service;

import java.util.List;

import com.epam.pizza.domain.Pizza;

public interface PizzaService {

	public Pizza getPizzaById(Integer id);
	public List<Pizza> findAll();
	public void modify(Pizza pizza);
	public void save(Pizza pizza);
}
