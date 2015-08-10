package com.epam.pizza.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.pizza.domain.Pizza;

@Repository("pizzaRepository")
public class PizzaMysqlDao implements PizzaRepository {
	@PersistenceContext
	private EntityManager em;

	public Pizza getPizzaByID(Integer id) {
		return em.find(Pizza.class, id);
	}

	public List<Pizza> findAll() {
		TypedQuery<Pizza> pizzas = em.createNamedQuery("findAll",  Pizza.class);
		return pizzas.getResultList();
	}

	public void save(Pizza pizza) {
		if (pizza.getId() != null) {
			em.merge(pizza);
		} else {
			em.persist(pizza);
		}
	}
}
