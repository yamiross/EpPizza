package com.epam.pizza.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.pizza.domain.Pizza;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class ShoppingCartController {
	@RequestMapping(method=RequestMethod.GET)
	public String viewCart() {
		return "viewCart";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String placeOrder(
			@ModelAttribute("cart") ShoppingCart cart) {
		cart.placeOrder(1);
		return "redirect:/orders";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String removeItemFromCart(
			@ModelAttribute("cart") ShoppingCart cart,
			@RequestParam("pizzaId") Pizza pizza,
			@RequestParam("amount") Integer amount) {
		if (amount <= 0) {
			cart.removeItem(pizza);
		} else {
			cart.changeAmount(pizza, amount);
		}
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removeItemFromCart(
			@ModelAttribute("cart") ShoppingCart cart,
			@RequestParam("pizzaId") Pizza pizza) {
		cart.removeItem(pizza);
		return "redirect:/cart";
	}
}
