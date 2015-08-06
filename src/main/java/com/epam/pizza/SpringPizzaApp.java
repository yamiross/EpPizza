package com.epam.pizza;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.pizza.domain.AccumulativeCard;
import com.epam.pizza.domain.Address;
import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.service.CustomerService;
import com.epam.pizza.service.OrderService;
import com.epam.pizza.service.PizzaService;

public class SpringPizzaApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
        
//        CustomerService customerService = appCtx.getBean("customerService", CustomerService.class);
//        Customer customer = customerService.findById(1);
//        
//        Map<Integer, Integer> pizzas = new HashMap<>();
//        pizzas.put(1,1);
//        pizzas.put(2,1);
//        pizzas.put(3,1);
//        
//        OrderService orderService = appCtx.getBean("orderService", OrderService.class);
//        Order order = orderService.placeNewOrder(customer, pizzas);
//        System.out.println(order); 
		
		PizzaService pizzaService = appCtx.getBean("pizzaService", PizzaService.class);
		System.out.println(pizzaService.findAll());
		
        appCtx.close();
	}
}
