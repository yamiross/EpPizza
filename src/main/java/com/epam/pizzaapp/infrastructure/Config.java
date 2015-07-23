package com.epam.pizzaapp.infrastructure;

public interface Config {
	Class<?> getImplementation(String beanName);
}
