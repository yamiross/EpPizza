package com.epam.pizza.domain;

import java.util.Map;
import java.util.Map.Entry;

public class TotalCostOrderCalculator {
	private static final double DISCOUNT = 0.3;

	public double calculateTotalOrderPrice(Map<Pizza, Integer> pizzas) {
		int count = 0;
		double totalPrice = 0;
		double biggestPrice = 0;
		Pizza pizza;
		if (pizzas != null) {
			for (Entry<Pizza, Integer> pizzaEntry: pizzas.entrySet()) {
				pizza = pizzaEntry.getKey();
				if (pizzaEntry.getValue() <= 0 || pizza == null || pizza.getPrice() <= 0) {
					throw new IllegalArgumentException();
				}
				count += pizzaEntry.getValue();
				totalPrice += pizza.getPrice() * pizzaEntry.getValue();
				if (biggestPrice < pizza.getPrice()) {
					biggestPrice = pizza.getPrice();
				}
			}
		}

		if (count <= 0 || count > 10) {
			throw new IllegalArgumentException();
		}
		if (count > 4) {
			totalPrice -= biggestPrice * DISCOUNT;
		}
		return totalPrice;
	}
}
