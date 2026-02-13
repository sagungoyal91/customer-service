package com.hrs.customer_service.service;

import com.hrs.customer_service.dto.CustomerRequest;
import com.hrs.customer_service.entity.Customer;
import com.hrs.customer_service.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

@Autowired
CustomerRepository customerRepository;

public Customer saveCustomer(CustomerRequest request){
    Customer customer = new Customer();
    customer.setName(request.getName());
    customer.setEmail(request.getEmail());
    customer=customerRepository.save(customer);
    return customer;
}

    public Optional<Customer> getCustomer(String customerId){
        return customerRepository.findById(customerId);
    }
}
