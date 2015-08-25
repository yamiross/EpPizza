package com.epam.pizza.repository;

import com.epam.pizza.domain.Customer;

public interface CustomerRepository {
	Customer findByName(String name);
	Customer findById(Integer id);
	void save(Customer customer);
}
