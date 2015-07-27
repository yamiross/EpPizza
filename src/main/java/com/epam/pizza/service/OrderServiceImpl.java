package com.epam.pizza.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.infrastructure.Benchmark;
//import com.epam.pizzaapp.infrastructure.ObjectFactory;
import com.epam.pizza.repository.OrderRepository;

public class OrderServiceImpl implements OrderService {
	
//	private ObjectFactory objectFactory = ObjectFactory.getInstance();
	
	private PizzaService pizzaService;
	private OrderRepository orderRepository;
	
	public OrderServiceImpl(PizzaService pizzaService, OrderRepository orderRepository) throws InstantiationException, IllegalAccessException {
		
		this.pizzaService = pizzaService;
		this.orderRepository = orderRepository;
		
//		pizzaService = (PizzaService) objectFactory.createObject("pizzaService");
//		orderRepository = (OrderRepository) objectFactory.createObject("orderRepository");
	}
	
	@Benchmark
	public Order placeNewOrder(Customer customer, Integer ... pizzasID) {
        List<Pizza> pizzas = new ArrayList<Pizza>();
       
        for(Integer id : pizzasID){
            pizzas.add(pizzaService.getPizzaByID(id));  // get Pizza from predifined in-memory list
        }
        Order newOrder = new Order(customer, pizzas);
       
        orderRepository.saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }
}
