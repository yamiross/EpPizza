package com.epam.pizza.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.pizza.domain.Order;

@Controller
@RequestMapping("/orders")
public class OrderController extends AbstractOrderContoller {

	@RequestMapping(method=RequestMethod.GET)
	public String viewCart(Model model) {
		List<Order> orders = orderService.findAllByCustomer(1);
		model.addAttribute("orders", orders);
		return "viewOrders";
	}
}
