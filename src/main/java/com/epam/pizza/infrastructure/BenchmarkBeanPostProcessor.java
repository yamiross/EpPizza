package com.epam.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ClassUtils;

@Named
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		Class<?> clazz = bean.getClass();
		for (Method m : clazz.getMethods()) {
			if (m.isAnnotationPresent(Benchmark.class)) {
				System.out.println("Bean Class = " + bean.getClass().getName());

				bean = createProxyObject(bean);

			}
		}
		return bean;
	}
	
	private Object createProxyObject(final Object obj) {
		final Class<?> type = obj.getClass();
		
		return Proxy.newProxyInstance(
				type.getClassLoader(), 
				ClassUtils.getAllInterfaces(type),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						Object retVal;

						if (type.getMethod(method.getName(),
								method.getParameterTypes())
								.isAnnotationPresent(Benchmark.class)) {

							System.out.println("Benchmark start: "
									+ method.getName());
							long start = System.nanoTime();
							retVal = method.invoke(obj, args);
							long result = System.nanoTime() - start;
							System.out.println(result);
							System.out.println("Benchmark finish: "
									+ method.getName());
						} else {
							retVal = method.invoke(obj, args);
						}
						return retVal;

					}
				});
	}
}
