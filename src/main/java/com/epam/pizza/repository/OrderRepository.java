package com.epam.pizza.repository;

import java.util.List;

import com.epam.pizza.domain.Order;

public interface OrderRepository {

	public void saveOrder(Order order);
	public List<Order> findAllByCustomer(Integer customerId);
	public List<Order> findAll();
}
