package com.epam.pizzaapp.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class JavaConfigApplicationContext implements ApplicationContext {

	private Config config;
	
	public JavaConfigApplicationContext(Config config) {
		this.config = config;	}

	public Object getBean(String beanName) throws Exception {
		Class<?> clazz = config.getImplementation(beanName);
		Constructor<?> cunstructor = clazz.getConstructors()[0]; 
		Parameter[] params = cunstructor.getParameters();
		
		if (params.length == 0) {
			return clazz.newInstance();
		}
		
		return null;
	}
}
