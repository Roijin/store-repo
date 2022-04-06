package com.mandiri.controller;

import com.mandiri.entity.Customer;
import com.mandiri.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer register(@RequestBody Customer customer){
        return customerService.register(customer);
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id){
        return customerService.getById(id);
    }
}
