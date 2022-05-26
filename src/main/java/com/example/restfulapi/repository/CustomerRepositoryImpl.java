package com.example.java92022.week4.RestFulApi.repository;

import com.example.java92022.week4.RestFulApi.domain.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private Map<String, Customer> employeeMap = new HashMap<>();

    @PostConstruct
    public void init() {
        Customer customer1 = new Customer("Tom", "1", new ArrayList<>(), new Date(), new Date(), true);
        Customer customer2 = new Customer("Jerry", "2", new ArrayList<>(), new Date(), new Date(), true);
        employeeMap.put(customer1.getId(), customer1);
        employeeMap.put(customer2.getId(), customer2);
    }

    @Override
    public Customer getCustomerById(String id) {
        return employeeMap.get(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return employeeMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void CreateCustomer(String id, String name) {
        if(employeeMap.containsKey(id)) throw new IllegalArgumentException("This user id already exists.");

        Customer newCustomer = new Customer(name, id, new ArrayList<>(), new Date(), new Date(), true);
        employeeMap.put(newCustomer.getId(),newCustomer);
    }

    @Override
    public void DeleteCustomer(String id) {
        if(!employeeMap.containsKey(id)) throw new IllegalArgumentException("Target user id does not exist.");
        employeeMap.remove(id);

    }

    @Override
    public void AddOrderToCustomer(String id, String orderId) {
        if(employeeMap.containsKey(id)) throw new IllegalArgumentException("This user id already exists.");
        employeeMap.get(id).getOrders().add(orderId);
    }

    @Override
    public List<String> getAllOrders(String id) {
        if(employeeMap.containsKey(id)) throw new IllegalArgumentException("This user id already exists.");
        return employeeMap.get(id).getOrders();
    }


}
