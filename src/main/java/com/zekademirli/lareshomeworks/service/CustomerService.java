package com.zekademirli.lareshomeworks.service;

import com.zekademirli.lareshomeworks.entity.Customer;
import com.zekademirli.lareshomeworks.repository.CustomerRepository;
import com.zekademirli.lareshomeworks.request.CreateCustomerRequest;
import com.zekademirli.lareshomeworks.request.UpdateCustomerRequest;
import com.zekademirli.lareshomeworks.response.CustomerResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(m -> modelMapper.map(m, CustomerResponse.class)).toList();

    }

    public Optional<CustomerResponse> getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer == null ? Optional.empty() : Optional.of(modelMapper.map(customer, CustomerResponse.class));
    }

    public CustomerResponse createCustomer(CreateCustomerRequest customer) {
        Customer customerEntity = modelMapper.map(customer, Customer.class);
        Customer savedCustomer = customerRepository.save(customerEntity);
        return modelMapper.map(savedCustomer, CustomerResponse.class);
    }

    public CustomerResponse updateCustomer(Long id, UpdateCustomerRequest updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        modelMapper.map(updatedCustomer, customer);
        Customer savedCustomer = null;
        if (customer != null) {
            savedCustomer = customerRepository.save(customer);
        }
        return modelMapper.map(savedCustomer, CustomerResponse.class);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
