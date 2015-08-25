/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.pizza.web;

import com.epam.pizza.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractOrderContoller {

    @Autowired
    protected OrderService orderService;
}
