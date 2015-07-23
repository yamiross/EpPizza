package com.epam.pizzaapp.infrastructure;

import java.util.HashMap;
import java.util.Map;

import com.epam.pizzaapp.repository.TestOrderRepository;
import com.epam.pizzaapp.repository.TestPizzaRepository;
import com.epam.pizzaapp.service.OrderServiceImpl;
import com.epam.pizzaapp.service.PizzaServiceImpl;

public class JavaConfig implements Config {

	private Map<String, Class<?>> map = new HashMap<String, Class<?>>();
	
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
