package com.epam.pizza.infrastructure;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForBenchmarkAnnotation {

	public Object checkAndCreateProxyObjForBenchmark(final Object obj) {
		Class<?> cl = obj.getClass();
		Method[] methods = cl.getMethods();
		for (Method m: methods) {
			if (m.isAnnotationPresent(Benchmark.class)) {
				return createProxyObject(obj);
			}
		}
		return obj;
	}

	private Object createProxyObject(final Object obj) {
		final Class<?> cl = obj.getClass();
		return Proxy.newProxyInstance(
				cl.getClassLoader(), 
				cl.getInterfaces(), 
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
						Method classMethod = cl.getMethod(method.getName(), method.getParameterTypes());
						if (classMethod.isAnnotationPresent(Benchmark.class)) {
							System.out.println("Benchmark starts " + method.getName());
							long start = System.nanoTime();
							Object returnVal = method.invoke(obj,  args);
							long finish = System.nanoTime();
							System.out.println("Benchmark finished " + method.getName());
							System.out.println("Benchmark time: " + (finish - start));
							return returnVal;
						}
						return method.invoke(obj,  args);
					}
				}
				);
	}
}
