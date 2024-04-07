package com.mtm.examples.customers.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mtm.examples.customers.domain.Customer;
import com.mtm.examples.customers.domain.CustomerType;
import com.mtm.examples.customers.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder().customerId(1).pesel("12345").name("Adam Kowalski")
                .type(CustomerType.INDIVIDUAL).build());
        customers.add(Customer.builder().customerId(2).pesel("12346").name("Anna Malinowska")
                .type(CustomerType.INDIVIDUAL).build());
        customers.add(Customer.builder().customerId(3).pesel("12347").name("Paweł Michalski")
                .type(CustomerType.INDIVIDUAL).build());
        customers.add(Customer.builder().customerId(4).pesel("12348").name("Karolina Lewandowska")
                .type(CustomerType.INDIVIDUAL).build());
        return customers;
    }

    @Override
    public Customer findByPesel(String pesel) {
        Optional<Customer> customer = getCustomers().parallelStream()
                .filter(account -> account.getPesel().equals(pesel)).findFirst();
        return customer.isPresent() ? customer.get() : null;
    }

    @Override
    public Customer findByCustomerId(Integer customerId) {
        Optional<Customer> customer = getCustomers().stream()
                .filter(account -> account.getCustomerId().intValue() == customerId.intValue()).findFirst();
        return customer.isPresent() ? customer.get() : null;
    }

    @Override
    public List<Customer> findAll() {
        return getCustomers();
    }

}