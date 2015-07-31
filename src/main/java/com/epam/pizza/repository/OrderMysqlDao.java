package com.epam.pizza.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.pizza.domain.Order;

@Repository("orderRepository")
public class OrderMysqlDao implements OrderRepository {
	@PersistenceContext
	private EntityManager em;
	
	public void saveOrder(Order order) {
		em.persist(order);
	}

}
