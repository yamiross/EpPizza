package com.epam.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="Pizza not found", value=HttpStatus.NOT_FOUND)
public class PizzaItemNotFoundException extends RuntimeException {
	public PizzaItemNotFoundException(String msg) {
		super(msg);
	}
}
