package com.hrs.customer_service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class Customer {
    @Id
    private String custId;
    private String name;
    private String email;
}
