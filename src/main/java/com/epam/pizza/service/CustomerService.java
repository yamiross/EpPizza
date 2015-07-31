package com.epam.pizza.service;

import com.epam.pizza.domain.Customer;

public interface CustomerService {
	Customer findById(Integer id);
	void save(Customer customer);
}
