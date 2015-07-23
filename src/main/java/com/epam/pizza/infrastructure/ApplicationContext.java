package com.epam.pizza.infrastructure;

public interface ApplicationContext {

	public Object getBean(String beanName) throws Exception;
}
