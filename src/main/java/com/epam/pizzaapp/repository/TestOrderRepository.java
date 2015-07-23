package com.epam.pizzaapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizzaapp.domain.Order;

public class TestOrderRepository implements OrderRepository {

	private List<Order> orders = new ArrayList<Order>();
	
	public void saveOrder(Order order) {
		orders.add(order);
	}
}
