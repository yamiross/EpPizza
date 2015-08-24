package com.epam.pizza.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.domain.PizzaType;

@Controller
@RequestMapping("/pizzas")
public class PizzaController extends AbstractPizzaContoller {

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
			@RequestParam(required=true, value="id")Pizza pizza) {
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
