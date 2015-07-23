package com.epam.pizzaapp.service;

import com.epam.pizzaapp.domain.Pizza;
//import com.epam.pizzaapp.infrastructure.ObjectFactory;
import com.epam.pizzaapp.repository.PizzaRepository;
import com.epam.pizzaapp.repository.TestPizzaRepository;

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
