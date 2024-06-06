package com.idat.semana2.service.impl;

import com.idat.semana2.model.Customer;
import com.idat.semana2.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @Override
    public List<Customer> allCustomers() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customer.setId(counter.incrementAndGet());
        customers.add(customer);
    }

    @Override
    public Optional<Customer> get(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public void editCustomer(Customer customer) {
        get(customer.getId()).ifPresent(c -> {
            c.setName(customer.getName());
            c.setLastName(customer.getLastName());
            c.setEmail(customer.getEmail());
            c.setBirthday(customer.getBirthday());
        });
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

}
