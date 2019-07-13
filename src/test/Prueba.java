/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cjava.service.CustomerService;
import cjava.service.impl.CustomerCSTDAO;

/**
 *
 * @author prog110519
 */
public class Prueba {
    
    public static void main(String[] args) {
        CustomerService customerService = new CustomerCSTDAO();
        
        customerService.findAll().stream()
                .forEach(c -> System.out.println(c.toString()));
        
    }
           
}
