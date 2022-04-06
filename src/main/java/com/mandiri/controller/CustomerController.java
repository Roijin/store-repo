package com.mandiri.controller;

import com.mandiri.dto.CustomPage;
import com.mandiri.dto.CustomerForm;
import com.mandiri.entity.Customer;
import com.mandiri.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    @DeleteMapping
    public void deleteById(@RequestParam String id){
        customerService.deleteById(id);
    }

    @GetMapping
    public CustomPage<Customer> search(
            @RequestParam (defaultValue = "1")Integer page,
            @RequestParam (defaultValue = "10") Integer size,
            @RequestParam (defaultValue = "") String searchName,
            @RequestParam (defaultValue = "") String searchUsername,
            @RequestParam (defaultValue = "") String searchEmail,
            @RequestParam (defaultValue = "") String searchGender,
            @RequestParam (defaultValue = "") String searchPhoneNumber,
            @RequestParam (defaultValue = "0001-01-01") String searchBirthDate) throws ParseException {
        LocalDate birthDate = LocalDate.parse(searchBirthDate, DateTimeFormatter.ISO_LOCAL_DATE);
        CustomerForm customerForm = new CustomerForm(searchName,searchUsername,birthDate,searchPhoneNumber,searchEmail,searchGender);
        Pageable pageable = PageRequest.of(page-1,size);
        return customerService.findAll(customerForm,pageable);
    }
}
