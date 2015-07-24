package com.epam.pizza.infrastructure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
		
		BeanBuilder beanBuilder = new BeanBuilder(beanName);
		beanBuilder.createObject();
		beanBuilder.createProxy();
		beanBuilder.callInitMethod();
		
		return beanBuilder.getObject();
	}
	
	class BeanBuilder {
		
		private Object obj;
		private Class cl;
		private String beanName;
		
		public BeanBuilder(String beanName) {
			this.beanName = beanName;
		}

		public void createObject() throws Exception {
			Class<?> clazz = config.getImplementation(beanName);
			Constructor<?> constructor = clazz.getConstructors()[0]; 
			Class<?>[] paramTypes = constructor.getParameterTypes();
			if (paramTypes.length == 0) {
				obj = clazz.newInstance();
				beans.put(beanName, obj);
				return;
			}
			
			Object[] args = new Object[paramTypes.length];
			String className;
			String argBeanName;
			for (int i = 0; i < paramTypes.length; i++) {
				className = paramTypes[i].getSimpleName();
				argBeanName = className.substring(0, 1).toLowerCase() + className.substring(1);
				args[i] = getBean(argBeanName);
			}
			obj = constructor.newInstance(args);
			beans.put(beanName, obj);
		}
		
		public void callInitMethod() throws Exception {
			cl = obj.getClass();
			Method method;
			try {
				method = cl.getMethod("init");
			} catch (NoSuchMethodException ignore) {
				return;
			}
			method.invoke(obj);
		}
		
		public void createProxy() {
			// TODO Auto-generated method stub
		}
		
		public Object getObject() {
			return obj;
		}
	}
}
