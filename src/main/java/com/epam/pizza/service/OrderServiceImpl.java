package com.epam.pizza.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.repository.OrderRepository;

@Named("orderService")
public class OrderServiceImpl implements OrderService {

	@Inject
	private PizzaService pizzaService;
	@Inject
	private OrderRepository orderRepository;
	
	public OrderServiceImpl() {	}
	
	@Transactional
	public Order placeNewOrder(Customer customer, Map<Integer, Integer> pizzasId) {
        Map<Pizza, Integer> pizzasForOrder = new HashMap<>();
        Pizza pizza;
        for(Entry<Integer, Integer> pizzaId : pizzasId.entrySet()){
        	pizza = pizzaService.getPizzaByID(pizzaId.getKey());
        	pizzasForOrder.put(pizza, pizzaId.getValue());
        }
        Order newOrder = getNewOrder();
        newOrder.setCustomer(customer);
        newOrder.setPizzas(pizzasForOrder);
       
        orderRepository.saveOrder(newOrder);
        return newOrder;
    }
	
	protected Order getNewOrder() {
		return new Order();
	}
}
