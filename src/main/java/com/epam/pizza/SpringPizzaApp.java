package com.epam.pizza;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Order;
import com.epam.pizza.service.OrderService;

public class SpringPizzaApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(new String[]{"appContext.xml"});
		
        Customer customer = new Customer(1, "Andrii");

        OrderService orderService = appCtx.getBean("orderService", OrderService.class);
        Order order = orderService.placeNewOrder(customer, 1, 2, 3);
        System.out.println(order); 
		
        appCtx.close();
	}
}
