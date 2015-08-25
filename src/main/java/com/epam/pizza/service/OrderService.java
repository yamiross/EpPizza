package com.epam.pizza.service;

import java.util.List;
import java.util.Map;

import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;

public interface OrderService {

	public Order placeNewOrder(String email, Map<Pizza, Integer> pizzas);
	public List<Order> findAllByCustomer(Integer customerId);
	public List<Order> findAll();
}
