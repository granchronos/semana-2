package com.idat.semana2.service;

import com.idat.semana2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> allCustomers();

    void addCustomer(Customer customer);

    Optional<Customer> get(Long id);

    void editCustomer(Customer customer);

    void deleteCustomer(Long id);
}
