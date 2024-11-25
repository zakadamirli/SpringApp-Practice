package com.zekademirli.lareshomeworks.controller;

import com.zekademirli.lareshomeworks.request.CreateCustomerRequest;
import com.zekademirli.lareshomeworks.request.UpdateCustomerRequest;
import com.zekademirli.lareshomeworks.response.CustomerResponse;
import com.zekademirli.lareshomeworks.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomerResponse> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerResponse createCustomer(@RequestBody CreateCustomerRequest customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
