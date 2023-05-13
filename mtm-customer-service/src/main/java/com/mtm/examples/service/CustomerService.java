package com.mtm.examples.service;

import com.mtm.examples.domain.Customer;

import java.util.List;

public interface CustomerService {

    public Customer findByPesel(String pesel);

    public Customer findByCustomerId(Integer customerId);

    public List<Customer> findAll();

}