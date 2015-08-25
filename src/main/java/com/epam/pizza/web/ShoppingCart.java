package com.epam.pizza.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.epam.pizza.domain.Customer;
import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.TotalCostOrderCalculator;
import com.epam.pizza.service.CustomerService;
import com.epam.pizza.service.OrderService;

@Named("shoppingCart")
@Scope("prototype")
public class ShoppingCart {
	@Inject
	private OrderService orderService;
	@Inject
	private CustomerService customerService;
	private Map<Pizza, Integer> cart;
	@Inject
	private TotalCostOrderCalculator costCalculator;
	
	public ShoppingCart() {
		reset();
	}
	
	public Map<Pizza, Integer> getCart() {
		return cart;
	}
	
	public void reset () {
		cart = new LinkedHashMap<Pizza, Integer>();
	}
	
	public void putItem(Pizza pizza, Integer amount) {
		cart.merge(pizza, amount, ((oldValue, newValue) -> oldValue + newValue));
	}
	
	public void removeItem(Pizza pizza) {
		cart.remove(pizza);
	}
	
	public void changeAmount(Pizza pizza, Integer amount) {
		cart.put(pizza, amount);
	}
	
	public void placeOrder(String name) {
		orderService.placeNewOrder(name, cart);
		reset();
	}
	
	public Integer getItemsCount() {
		Integer count = 0;
		count += cart.values().stream().mapToInt(value -> value).sum();
		return count;
	}
	
	public Double getTotalSum() {
		if (cart.isEmpty()) {
			return 0D;
		}
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
		Customer customer = customerService.findByName(name);
		return costCalculator.calculateTotalOrderPrice(cart, customer.getAccumulativeCard());
	}
}
	