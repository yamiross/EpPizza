package com.epam.pizza.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.TotalCostOrderCalculator;
import com.epam.pizza.repository.OrderRepository;

@Named("orderService")
public class OrderServiceImpl implements OrderService {

	@Inject
	private CustomerService customerService;
	@Inject
	private OrderRepository orderRepository;
	@Inject
	private TotalCostOrderCalculator priceCalculator;

	public OrderServiceImpl() {	}

	@Override
	public List<Order> findAllByCustomer(Integer customerId) {
		return orderRepository.findAllByCustomer(customerId);
	}
	
	@Transactional
	public Order placeNewOrder(Integer customerId, Map<Pizza, Integer> pizzas) {
		Customer customer = customerService.findById(customerId);
		Order newOrder = getNewOrder();
		if (customer != null) {
			newOrder.setCustomer(customer);
			newOrder.setAddress(customer.getAccumulativeCard().getAddress());
			newOrder.setPizzas(pizzas);
			
			Double orderPrice = priceCalculator.calculateTotalOrderPrice(pizzas);
			newOrder.setPrice(orderPrice);
			
			Double accumulated = customer.getAccumulativeCard().getAccumulated();
			accumulated += orderPrice;
			customer.getAccumulativeCard().setAccumulated(accumulated);
			
			orderRepository.saveOrder(newOrder);
		}
		return newOrder;
	}

	protected Order getNewOrder() {
		return new Order();
	}
}
