package com.epam.pizzaapp.repository;

import java.util.Arrays;
import java.util.List;

import com.epam.pizzaapp.domain.Pizza;
import com.epam.pizzaapp.domain.PizzaType;

public class TestPizzaRepository implements PizzaRepository {
	
	private List<Pizza> pizzas = Arrays.asList(
			new Pizza(1, "Neapolitana", 20.0, PizzaType.MEAT),
			new Pizza(2, "FishEye", 24.0, PizzaType.SEA),
			new Pizza(3, "Margarita", 16.0, PizzaType.VEGETERIAN),
			new Pizza(4, "Vulcanic", 18.0, PizzaType.MEAT));
	
	public Pizza getPizzaByID(Integer id) {
		for (Pizza pizza: pizzas) {
			if (pizza.getId() == id) {
				return pizza;
			}
		}
		return null;
	}
}
