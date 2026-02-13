package com.hrs.customer_service.repo;

import com.hrs.customer_service.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByEmail(String email);
}
