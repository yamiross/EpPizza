package com.epam.pizza.repository;

import com.epam.pizza.domain.Order;

public interface OrderRepository {

	public void saveOrder(Order order);
}
