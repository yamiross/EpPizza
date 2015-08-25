package com.epam.pizza.web;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.pizza.domain.Pizza;

@Controller
@RequestMapping("/profile/cart")
@SessionAttributes("cart")
public class ShoppingCartController extends AbstractCartContoller {
	@RequestMapping(method=RequestMethod.GET)
	public String viewCart(Model model) {
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", getShoppingCart());
		}
		return "viewCart";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String placeOrder(
			@ModelAttribute("cart") ShoppingCart cart) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        cart.placeOrder(auth.getName());
		return "redirect:/profile/orders";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String editItemInCart(
			@ModelAttribute("cart") ShoppingCart cart,
			@RequestParam("pizzaId") Pizza pizza,
			@RequestParam("amount") Integer amount) {
		if (amount <= 0) {
			cart.removeItem(pizza);
		} else {
			cart.changeAmount(pizza, amount);
		}
		return "redirect:/profile/cart";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String removeItemFromCart(
			@ModelAttribute("cart") ShoppingCart cart,
			@RequestParam("pizzaId") Pizza pizza) {
		cart.removeItem(pizza);
		return "redirect:/profile/cart";
	}
	
	@Lookup
	protected ShoppingCart getShoppingCart() {return null;};
}
