package com.example.restfulapi.service;

import com.example.restfulapi.domain.Customer;
import com.example.restfulapi.domain.CustomerDTO;
import com.example.restfulapi.repository.CustomerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Log logger = LogFactory.getLog(CustomerServiceImpl.class);
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public CustomerDTO getCustomerById(String id) {
        Customer customer = customerRepository.getCustomerById(id);
        if(customer == null) {
            throw new RuntimeException(id + ": employee is null");
        }
        return new CustomerDTO(customer);

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository
                .getAllCustomers()
                .stream()
                .map(e -> new CustomerDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public void CreateCustomer(String id, String name) {
        customerRepository.CreateCustomer(id,name);
    }

    @Override
    public void DeleteCustomer(String id) {
        customerRepository.DeleteCustomer(id);
    }

    @Override
    public void AddOrderToCustomer(String id, String orderId) {
        customerRepository.AddOrderToCustomer(id,orderId);
    }

    @Override
    public List<String> getAllOrders(String id) {
        return customerRepository.getAllOrders(id);
    }
}

