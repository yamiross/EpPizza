package com.epam.pizza.repository;

import java.util.List;

import com.epam.pizza.domain.Pizza;

public interface PizzaRepository {
	
	public Pizza getPizzaByID(Integer id);
	public List<Pizza> findAll();
	public void save(Pizza pizza);
}