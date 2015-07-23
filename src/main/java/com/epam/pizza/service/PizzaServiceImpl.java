package com.epam.pizza.service;

import com.epam.pizza.domain.Pizza;
//import com.epam.pizzaapp.infrastructure.ObjectFactory;
import com.epam.pizza.repository.PizzaRepository;
import com.epam.pizza.repository.TestPizzaRepository;

public class PizzaServiceImpl implements PizzaService {
	
//	private ObjectFactory objectFactory = ObjectFactory.getInstance();
	
	private PizzaRepository pizzaRepository = new TestPizzaRepository();
	
	public PizzaServiceImpl(PizzaRepository pizzaRepository) throws InstantiationException, IllegalAccessException {
		
		this.pizzaRepository = pizzaRepository;
		
//		pizzaRepository = (PizzaRepository) objectFactory.createObject("pizzaRepository");
	}
	
	public Pizza getPizzaByID(Integer id) {
		return pizzaRepository.getPizzaByID(id);
	}

}
