package com.zekademirli.lareshomeworks.service;

import com.zekademirli.lareshomeworks.entity.Customer;
import com.zekademirli.lareshomeworks.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        updatedCustomer.setId(id);
        return customerRepository.save(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
