package com.epam.pizzaapp.repository;

import com.epam.pizzaapp.domain.Pizza;

public interface PizzaRepository {
	
	public Pizza getPizzaByID(Integer id);
}
