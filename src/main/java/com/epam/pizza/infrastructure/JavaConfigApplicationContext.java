package com.epam.pizza.infrastructure;

import java.lang.reflect.Constructor;

public class JavaConfigApplicationContext implements ApplicationContext {

	private Config config;
	
	public JavaConfigApplicationContext(Config config) {
		this.config = config;	}

	public Object getBean(String beanName) throws Exception {
		Class<?> clazz = config.getImplementation(beanName);
		Constructor<?> constructor = clazz.getConstructors()[0]; 
		Class<?>[] paramTypes = constructor.getParameterTypes();
		
		if (paramTypes.length == 0) {
			return clazz.newInstance();
		}
		
		Object[] args = new Object[paramTypes.length];
		String className;
		String argBeanName;
		for (int i = 0; i < paramTypes.length; i++) {
			className = paramTypes[i].getSimpleName();
			argBeanName = className.substring(0, 1).toLowerCase() + className.substring(1);
			args[i] = getBean(argBeanName);
		}
		return constructor.newInstance(args);
	}
}
