package com.epam.pizzaapp;

import com.epam.pizzaapp.domain.Customer;
import com.epam.pizzaapp.domain.Order;
import com.epam.pizzaapp.infrastructure.ApplicationContext;
import com.epam.pizzaapp.infrastructure.Config;
import com.epam.pizzaapp.infrastructure.JavaConfig;
import com.epam.pizzaapp.infrastructure.JavaConfigApplicationContext;
import com.epam.pizzaapp.infrastructure.ObjectFactory;
import com.epam.pizzaapp.repository.OrderRepository;
import com.epam.pizzaapp.repository.PizzaRepository;
import com.epam.pizzaapp.service.OrderService;
import com.epam.pizzaapp.service.OrderServiceImpl;
import com.epam.pizzaapp.service.PizzaService;
import com.epam.pizzaapp.service.PizzaServiceImpl;

public class PizzaApp {
	public static void main(String[] args) throws Exception {
        Customer customer = new Customer(1, "Andrii");        
        
//        ObjectFactory objectFactory = ObjectFactory.getInstance();
        
//        OrderService orderService = (OrderService) objectFactory.createObject("orderService");
        
        Config config = new JavaConfig();
        ApplicationContext context = new JavaConfigApplicationContext(config);
        PizzaRepository pizzaRepository = (PizzaRepository) context.getBean("pizzaRepository");
        OrderRepository orderRepository = (OrderRepository) context.getBean("orderRepository");
        
        OrderService orderService = new OrderServiceImpl(new PizzaServiceImpl(pizzaRepository), orderRepository);
        Order order = orderService.placeNewOrder(customer, 1, 2, 3);
        
        System.out.println(order);
    }
}
