package com.epam.pizza.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.epam.pizza.domain.Pizza;

@RestController
@RequestMapping("/rest/pizzas")
public class PizzaRestfulController extends AbstractPizzaContoller {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pizza>> viewPizzas() {
		List<Pizza> pizzas = pizzaService.findAll();
		if (pizzas == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pizzas, HttpStatus.OK);
	}

	@RequestMapping(value="/{pizzaId}", method=RequestMethod.GET)
	public ResponseEntity<Pizza> viewPizza(@PathVariable("pizzaId") Pizza pizza) {
		if (pizza == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}

	@RequestMapping(value="/{pizzaId}", 
			method=RequestMethod.PUT,
			headers = "Content-Type=application/json")
	public ResponseEntity<Pizza> editPizza(@PathVariable("pizzaId") Integer pizzaId,
			@RequestBody Pizza pizza) {
		pizza.setId(pizzaId);
		pizzaService.modify(pizza);
		//			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		return new ResponseEntity<>(pizza, HttpStatus.OK);
	}

	@RequestMapping(
			method = RequestMethod.POST,
			headers = "Content-Type=application/json")
	public ResponseEntity<?> createNewPizza(
			@RequestBody Pizza pizza, 
			UriComponentsBuilder builder) {        
		System.out.println(pizza);
		pizzaService.save(pizza);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				builder.path("/rest/pizzas/{id}")
				.buildAndExpand(pizza.getId()).toUri());       

		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
}
