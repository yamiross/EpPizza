package com.epam.pizza.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.repository.CustomerRepository;

@Named("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private CustomerRepository customerRepository;
	
	public Customer findById(Integer id) {
		return customerRepository.findById(id);
	}
	
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Transactional
	public void save(Customer customer) {
		customerRepository.save(customer);
	}

}
