package com.epam.pizzaapp.infrastructure;

public interface ApplicationContext {

	public Object getBean(String beanName) throws Exception;
}
