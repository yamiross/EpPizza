package com.epam.pizza.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.repository.PizzaRepository;

@Named("pizzaService")
public class PizzaServiceImpl implements PizzaService {
	@Inject
	private PizzaRepository pizzaRepository;
	
	public Pizza getPizzaById(Integer id) {
		return pizzaRepository.getPizzaById(id);
	}

	public List<Pizza> findAll() {
		return pizzaRepository.findAll();
	}
	
	@Transactional
	public void modify(Pizza pizza) {
		pizzaRepository.modify(pizza);
	};
	
	@Transactional
	public void save(Pizza pizza) {
		pizzaRepository.save(pizza);
	}
}
