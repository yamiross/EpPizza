package com.epam.pizza.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;
import com.epam.pizza.exception.PizzaItemNotFoundException;
import com.epam.pizza.service.PizzaService;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	@Inject
	private PizzaService pizzaService;

	@RequestMapping(method=RequestMethod.GET)
	public String view(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		return "viewpizza";
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String addPage(Model model) {
		model.addAttribute("pizzaTypes", PizzaType.values());
		return "createpizza";
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String add(@ModelAttribute Pizza pizza) {
		pizzaService.save(pizza);
		return "redirect:";
	}

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String addForm(Model model,
			@RequestParam(required=true, value="id")Integer id) {
		Pizza pizza = pizzaService.getPizzaByID(id);
		if (pizza == null) {
			throw new PizzaItemNotFoundException("Pizza id : " + id);
		}
		model.addAttribute("pizza", pizza);
		model.addAttribute("pizzaTypes", PizzaType.values());
		return "editpizza";
	}

	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String addForm(@ModelAttribute Pizza pizza) {
		pizzaService.save(pizza);
		return "redirect:";
	}
}
