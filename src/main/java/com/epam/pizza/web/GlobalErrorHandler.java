package com.epam.pizza.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.epam.pizza.exception.PizzaItemNotFoundException;

@ControllerAdvice
@EnableWebMvc
public class GlobalErrorHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PizzaItemNotFoundException.class)
	public ModelAndView exceptionHandler(	
			Exception exception,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("ex", exception);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}
}
