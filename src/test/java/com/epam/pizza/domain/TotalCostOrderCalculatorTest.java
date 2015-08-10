//package com.epam.pizza.domain;
//
//import static org.junit.Assert.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.junit.Test;
//
//public class TotalCostOrderCalculatorTest {
//
//	private static double DELTA = 0.005;
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceExceedLowerAmountLimitThrowException() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceExceedUpperAmountLimitThrowException() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		for (int i = 1; i <= 11; i++) {
//			pizzas.put(new Pizza(1, "Margarita", 1.0, PizzaType.VEGETERIAN), 1);
//		}
//		System.out.println(pizzas.size());
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//	
//	@Test
//	public void testCalculateTotalOrderPriceOrderedWithOnePizza() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		double pizzaPrice = 23.3;
//		pizzas.put(new Pizza(1, "Margarita", pizzaPrice, PizzaType.VEGETERIAN), 1);
//		double expectedPrice = 23.3;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		double price = calculator.calculateTotalOrderPrice(pizzas);
//		
//		assertEquals(expectedPrice, price, DELTA);
//	}
//	
//	@Test
//	public void testCalculateTotalOrderPriceOrderedWithPreDiscountAmount() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		double pizzaPrice = 12.2;
//		for (int i = 1; i <= 4; i++) {
//			pizzas.put(new Pizza(i, "Pizza" + i, pizzaPrice, PizzaType.MEAT), 1);
//		}
//		double expectedPrice = 48.8;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		double price = calculator.calculateTotalOrderPrice(pizzas);
//		
//		assertEquals(expectedPrice, price, DELTA);
//	}
//	
//	@Test
//	public void testCalculateTotalOrderPriceOrderedWithLowerDiscountAmountLimit() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		double pizzaPrice = 12.2;
//		for (int i = 1; i <= 4; i++) {
//			pizzas.put(new Pizza(i, "Pizza" + i, pizzaPrice, PizzaType.MEAT), 1);
//		}
//		pizzas.put(new Pizza(5, "Pizza5", 15.0, PizzaType.MEAT), 1);
//		double expectedPrice = 59.3;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		double price = calculator.calculateTotalOrderPrice(pizzas);
//
//		assertEquals(expectedPrice, price, DELTA);
//	}
//	
//	@Test
//	public void testCalculateTotalOrderPriceOrderedWithTenPizza() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		double pizzaPrice = 23.3;
//		for (int i = 1; i <= 10; i++) {
//			pizzas.put(new Pizza(i, "Pizza" + i, pizzaPrice, PizzaType.SEA), 1);
//		}
//		double expectedPrice = 226.01;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		double price = calculator.calculateTotalOrderPrice(pizzas);
//		
//		assertEquals(expectedPrice, price, DELTA);
//	}
//	
//	@Test
//	public void testCalculateTotalOrderPriceOrderedWithingDiscountAmountAmountWithTwoTopPricePizzas() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		double pizzaPrice = 20.0;
//		double topPrice = 25.0;
//		for (int i = 1; i <= 4; i++) {
//			pizzas.put(new Pizza(i, "Pizza" + i, pizzaPrice, PizzaType.SEA), 1);
//		}
//		for (int i = 5; i <= 6; i++) {
//			pizzas.put(new Pizza(i, "Pizza" + i, topPrice, PizzaType.MEAT), 1);
//		}
//		double expectedPrice = 122.5;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		double price = calculator.calculateTotalOrderPrice(pizzas);
//		
//		assertEquals(expectedPrice, price, DELTA);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceOrderedForNegativePizzaEntryAmount() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		pizzas.put(new Pizza(1, "Pizza1", 15.0, PizzaType.MEAT), 2);
//		pizzas.put(new Pizza(2, "Pizza2", 20.0, PizzaType.VEGETERIAN), -1);
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceOrderedForNegativePizzaEntryPrice() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		pizzas.put(new Pizza(1, "Pizza1", 15.0, PizzaType.MEAT), 2);
//		pizzas.put(new Pizza(2, "Pizza2", -20.0, PizzaType.VEGETERIAN), 1);
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceOrderedForNullMap() {
//		Map<Pizza, Integer> pizzas = null;
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//	
//	@Test(expected = IllegalArgumentException.class)
//	public void testCalculateTotalOrderPriceOrderedForNullPizzaInMap() {
//		Map<Pizza, Integer> pizzas = new HashMap<>();
//		pizzas.put(null, 5);
//		
//		TotalCostOrderCalculator calculator = new TotalCostOrderCalculator();
//		calculator.calculateTotalOrderPrice(pizzas);
//	}
//}
