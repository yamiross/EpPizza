package com.epam.pizza.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.epam.pizza.domain.Order;

@Repository("orderRepository")
public class OrderMysqlDao implements OrderRepository {
	@PersistenceContext
	private EntityManager em;
	
	public List<Order> findAll() {
		return em.createQuery("FROM Order", Order.class).getResultList();
	}
	
	public List<Order> findAllByCustomer(Integer customerId) {
		TypedQuery<Order> query = em.createNamedQuery("findAllByCustomer", Order.class);
		query.setParameter("customerId", customerId);
		return query.getResultList();
	}
	
	public void saveOrder(Order order) {
		em.persist(order);
	}

}
