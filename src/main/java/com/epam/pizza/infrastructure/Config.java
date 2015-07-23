package com.epam.pizza.infrastructure;

public interface Config {
	Class<?> getImplementation(String beanName);
}
