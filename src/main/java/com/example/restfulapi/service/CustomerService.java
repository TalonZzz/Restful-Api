package com.example.restfulapi.service;


import com.example.restfulapi.domain.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerDTO getCustomerById(String id);
    List<CustomerDTO> getAllCustomers();
    void CreateCustomer(String id, String name);
    void DeleteCustomer(String id);
    void AddOrderToCustomer(String id, String orderId);
    List<String> getAllOrders(String id);

}
