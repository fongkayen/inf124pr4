/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uci.rest.model;

import java.util.ArrayList;

/**
 *
 * @author Nerianne
 */
public class Cart {
    private ArrayList<Order> orders;
    
    public Cart(){
        orders = new ArrayList<Order>();
    }
    public void addOrder(Order order){
        orders.add(order);
    }
}