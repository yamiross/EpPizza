package com.epam.pizza.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.infrastructure.Benchmark;
import com.epam.pizza.repository.OrderRepository;
import com.epam.pizza.repository.TestOrderRepository;

@Named("orderService")
public class OrderServiceImpl implements OrderService {

	@Inject
	private PizzaService pizzaService;
	@Inject
	private OrderRepository orderRepository;
	
	@Benchmark
	@Transactional
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
        Pizza pizza;
        for(Integer id : pizzasID){
        	pizza = pizzaService.getPizzaByID(id);
            pizzas.add(pizza);
        }
        Order newOrder = getNewOrder();
        newOrder.setCustomer(customer);
        newOrder.setPizzas(pizzas);
       
        orderRepository.saveOrder(newOrder);
        return newOrder;
    }
	
	protected Order getNewOrder() {
		return new Order();
	}
}
