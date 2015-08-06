package com.epam.pizza.service;

import java.util.Map;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;

public interface OrderService {

	public Order placeNewOrder(Customer customer, Map<Integer, Integer> pizzasId);
}
