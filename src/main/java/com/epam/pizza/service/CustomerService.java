package com.epam.pizza.service;

import com.epam.pizza.domain.Customer;

public interface CustomerService {
	Customer findById(Integer id);
	Customer findByName(String name);
	void save(Customer customer);
}
