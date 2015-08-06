//package com.epam.pizza;
//
//import com.epam.pizza.domain.Customer;
//import com.epam.pizza.domain.Order;
//import com.epam.pizza.infrastructure.ApplicationContext;
//import com.epam.pizza.infrastructure.Config;
//import com.epam.pizza.infrastructure.JavaConfig;
//import com.epam.pizza.infrastructure.JavaConfigApplicationContext;
//import com.epam.pizza.service.OrderService;
//
//public class PizzaApp {
//	public static void main(String[] args) throws Exception {
//        Customer customer = new Customer(1, "Andrii");        
//        
//        ObjectFactory objectFactory = ObjectFactory.getInstance();
//        
//        OrderService orderService = (OrderService) objectFactory.createObject("orderService");
//        
//        Config config = new JavaConfig();
//        ApplicationContext context = new JavaConfigApplicationContext(config);
//        
//        OrderService orderService = (OrderService) context.getBean("orderService");
//        Order order = orderService.placeNewOrder(customer, 1, 2, 3);
//        
//        System.out.println(order);
//    }
//}
