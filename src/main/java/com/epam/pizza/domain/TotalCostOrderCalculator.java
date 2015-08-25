package com.epam.pizza.domain;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.epam.pizza.domain.Pizza;

@Component
public class TotalCostOrderCalculator {
	private static final double FIFTH_PIZZA_DISCOUNT = 0.3;
	private static final double FIRST_LEVEL_DISCOUNT = 0.05;

	public double calculateTotalOrderPrice(Map<Pizza, Integer> pizzas,	AccumulativeCard accumulativeCard) {
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
			totalPrice -= calculateMoreThanFourItemsDiscount(biggestPrice);
		}
		totalPrice -= calculateAccumulativeCardDiscount(totalPrice, accumulativeCard);
		return totalPrice;
	}

	private double calculateMoreThanFourItemsDiscount(double biggestPrice) {
		return biggestPrice * FIFTH_PIZZA_DISCOUNT;
	}
	
	private double calculateAccumulativeCardDiscount(double totalPrice, AccumulativeCard accumulativeCard) {
		if (accumulativeCard != null && accumulativeCard.getAccumulated() != null) {
			if (accumulativeCard.getAccumulated() >= 200) {
				return totalPrice * FIRST_LEVEL_DISCOUNT;	
			}
		}
		return 0;
	}
}
