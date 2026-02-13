package com.hrs.customer_service.controller;

import com.hrs.customer_service.dto.CustomerRequest;
import com.hrs.customer_service.entity.Customer;
import com.hrs.customer_service.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;

    @PostMapping
    ResponseEntity<Customer> customer(@RequestBody CustomerRequest customerRequest){
        logger.info("inside save customer: "+ customerRequest.getName());
       Customer customer= customerService.saveCustomer(customerRequest);
        logger.info("customer saved: "+ customer.getCustId());
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    ResponseEntity<Customer> customer(@RequestParam String customerId){
        logger.info("inside fetch customer: "+ customerId);
        Optional<Customer> customer= customerService.getCustomer(customerId);
        logger.info("customer fetched: " +
                (customer.isPresent() ? customer.get().getCustId() : "Customer doesnot exist"));
        return ResponseEntity.ok(customer.get());
    }
}
