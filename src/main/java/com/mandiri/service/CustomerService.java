package com.mandiri.service;

import com.mandiri.constants.ResponseMessage;
import com.mandiri.dto.CustomPage;
import com.mandiri.dto.CustomerForm;
import com.mandiri.entity.Customer;
import com.mandiri.entity.Stock;
import com.mandiri.entity.Store;
import com.mandiri.repository.CustomerRepository;
import com.mandiri.specification.CustomerSpecification;
import com.mandiri.specification.StockSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerService implements CRUDService<Customer, CustomerForm,String>{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomPage<Customer> findAll(CustomerForm customerForm, Pageable pageable) {
        CustomerSpecification customerSpecification = new CustomerSpecification(customerForm);
        Page<Customer> customerPage = customerRepository.findAll(customerSpecification,pageable);
        return new CustomPage<Customer>(customerPage);
    }

    @Override
    public Customer getById(String id) {
        customerValidation(id);
        return customerRepository.findById(id).get();
    }

    private void customerValidation(String id) {
        if(!customerRepository.existsById(id)){
            String message = String.format(ResponseMessage.RESOURCE_NOT_FOUND, Customer.class.getSimpleName(), id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        }
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
    public void deleteById(String id) {
        customerValidation(id);
        customerRepository.deleteById(id);
    }
}
