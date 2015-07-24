package com.epam.pizza.infrastructure;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class JavaConfigApplicationContext implements ApplicationContext {

	private Config config;
	private final Map<String, Object> beans = new HashMap<String, Object>();
	
	public JavaConfigApplicationContext(Config config) {
		this.config = config;	}

	public Object getBean(String beanName) throws Exception {
		Object bean = beans.get(beanName);
		if (bean != null) {
			return bean;
		}
		
		Class<?> clazz = config.getImplementation(beanName);
		Constructor<?> constructor = clazz.getConstructors()[0]; 
		Class<?>[] paramTypes = constructor.getParameterTypes();
		if (paramTypes.length == 0) {
			bean = clazz.newInstance();
			beans.put(beanName, bean);
			return bean;
		}
		
		Object[] args = new Object[paramTypes.length];
		String className;
		String argBeanName;
		for (int i = 0; i < paramTypes.length; i++) {
			className = paramTypes[i].getSimpleName();
			argBeanName = className.substring(0, 1).toLowerCase() + className.substring(1);
			args[i] = getBean(argBeanName);
		}
		bean = constructor.newInstance(args);
		beans.put(beanName, bean);
		return bean;
	}
}
