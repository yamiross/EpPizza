package com.epam.pizzaapp.repository;

import com.epam.pizzaapp.domain.Order;

public interface OrderRepository {

	public void saveOrder(Order order);
}
