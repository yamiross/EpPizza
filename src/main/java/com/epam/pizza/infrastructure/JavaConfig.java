package com.epam.pizza.infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.epam.pizza.repository.TestOrderRepository;
import com.epam.pizza.repository.TestPizzaRepository;
import com.epam.pizza.service.OrderServiceImpl;
import com.epam.pizza.service.PizzaServiceImpl;

public class JavaConfig implements Config {

	private final Map<String, Class<?>> map = new HashMap<String, Class<?>>();
	
	{
		map.put("pizzaService", PizzaServiceImpl.class);
		map.put("pizzaRepository", TestPizzaRepository.class);
		map.put("orderService", OrderServiceImpl.class);
		map.put("orderRepository", TestOrderRepository.class);
	}
	
	public Class<?> getImplementation(String beanName) {
		return map.get(beanName);
	}

}
