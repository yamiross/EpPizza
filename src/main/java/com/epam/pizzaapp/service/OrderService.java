package com.epam.pizzaapp.service;

import com.epam.pizzaapp.domain.Customer;
import com.epam.pizzaapp.domain.Order;

public interface OrderService {

	public Order placeNewOrder(Customer customer, Integer ... pizzasID);
}
