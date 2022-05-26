package com.example.java92022.week4.RestFulApi.controller;

import com.example.java92022.week4.RestFulApi.domain.CustomerDTO;
import com.example.java92022.week4.RestFulApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }


    @GetMapping("/addCustomer/{id}/{name}")
    public ResponseEntity<Void> createCustomer(@PathVariable String id, @PathVariable String name){
        customerService.CreateCustomer(id,name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        customerService.DeleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/addOrder/{id}/{orderId}")
    public ResponseEntity<Void> addOrder(@PathVariable String id, @PathVariable String orderId){
        customerService.AddOrderToCustomer(id,orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<List<String>> getAllOrders(@PathVariable String id){
        return new ResponseEntity<>(customerService.getAllOrders(id),HttpStatus.OK);
    }

}
