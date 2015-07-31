package com.epam.pizza.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epam.pizza.domain.Customer;

@Repository("customerRepository")
public class CustomerMysqlDao implements CustomerRepository {
	@PersistenceContext
	private EntityManager em;
	
	public Customer findById(Integer id) {
		return em.find(Customer.class, id);
	}

	public void save(Customer customer) {
		em.persist(customer);
	}
}
