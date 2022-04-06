package com.mandiri.service;

import com.mandiri.dto.CustomPage;
import com.mandiri.dto.CustomerForm;
import com.mandiri.entity.Customer;
import com.mandiri.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CRUDService<Customer, CustomerForm,String>{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomPage<Customer> findAll(CustomerForm customerForm, Pageable pageable) {
        return null;
    }

    @Override
    public Customer getById(String s) {
        return null;
    }

    @Override
    public Customer register(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }
}
