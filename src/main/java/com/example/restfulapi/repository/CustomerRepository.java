package com.example.restfulapi.repository;

import com.example.restfulapi.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
    void CreateCustomer(String id, String name);
    void DeleteCustomer(String id);
    void AddOrderToCustomer(String id, String orderId);
    List<String> getAllOrders(String id);
}
