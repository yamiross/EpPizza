package com.epam.pizza.repository;

import com.epam.pizza.domain.Pizza;

public interface PizzaRepository {
	
	public Pizza getPizzaByID(Integer id);
}
