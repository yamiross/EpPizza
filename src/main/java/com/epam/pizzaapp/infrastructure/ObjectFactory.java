package com.epam.pizzaapp.infrastructure;

public class ObjectFactory {

	private static ObjectFactory instance;
	
	private Config config = new JavaConfig();
	
	private ObjectFactory() {
	}
	
	public static ObjectFactory getInstance() {
		
		if (instance == null) {
			instance = new ObjectFactory();
		}
		return instance;
	}
	
	public Object createObject(String beanName) throws InstantiationException, IllegalAccessException {
		Class<?> clazz = config.getImplementation(beanName);
		return clazz.newInstance();
	}
}
