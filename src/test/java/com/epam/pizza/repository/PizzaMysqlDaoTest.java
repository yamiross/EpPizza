package com.epam.pizza.repository;

import javax.inject.Inject;

import org.junit.Test;
import static org.junit.Assert.*;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;

public class PizzaMysqlDaoTest extends ITRepositoryTestTemplate {
	@Inject
	private PizzaRepository pizzaRepository;
	
	@Test
	public void testGetPizzaById() {
		Pizza pizza = new Pizza();
		pizza.setName("TestPizza");
		pizza.setPrice(22.0);
		pizza.setType(PizzaType.MEAT);
		
		pizzaRepository.save(pizza);

		assertNotNull(pizza.getId());
	}
}
