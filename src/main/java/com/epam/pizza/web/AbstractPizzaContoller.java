/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.pizza.web;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.epam.pizza.domain.Pizza;
import com.epam.pizza.exception.PizzaItemNotFoundException;

/**
 *
 * @author andrii
 */
public abstract class AbstractPizzaContoller {

    @Autowired
    protected com.epam.pizza.service.PizzaService pizzaService;

    private Pizza getPizzaById(Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID<0");
        }
        Pizza pizza = pizzaService.getPizzaById(id);
        if (pizza == null) {
            throw new PizzaItemNotFoundException("Pizza id" + id + " not found");
        }
        return pizza;
    }

    @InitBinder
    protected void pizzaBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Pizza.class,
                new PropertyEditorSupport() {
                    @Override
                    public void setAsText(String pizzaId) {
                        Pizza pizza = null;
                        if (pizzaId != null && !pizzaId.trim().isEmpty()) {
                            Integer id = Integer.valueOf(pizzaId);
                            pizza = getPizzaById(id);
                        }
                        setValue(pizza);
                    }
                }
        );
    }
}
