package com.epam.pizza.service;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;

public interface OrderService {

	public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
