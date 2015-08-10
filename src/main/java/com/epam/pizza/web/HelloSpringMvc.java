package com.epam.pizza.web;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.pizza.service.PizzaService;

//@Controller("helloController")
public class HelloSpringMvc {
	@Inject
	private PizzaService pizzaService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello SpringMVC";
	}
	
	@RequestMapping(value = "/pizzas", method=RequestMethod.GET)
	public String handleDefaultRequest(Model model) throws Exception {
		model.addAttribute("date", new Date());
		return "pizza";
	}
}
