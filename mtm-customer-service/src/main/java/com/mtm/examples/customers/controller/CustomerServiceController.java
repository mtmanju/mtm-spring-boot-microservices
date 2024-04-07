package com.mtm.examples.customers.controller;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.customers.domain.Account;
import com.mtm.examples.customers.domain.Customer;

@RequestMapping("/customers")
public interface CustomerServiceController {

    EntityModel<Customer> findCustomersByCustomerId(Integer customerId);

    EntityModel<Customer> findByPesel(String pesel);

    List<Customer> findAll();

    List<Account> findAccountsByCustomerId(Integer customerId);

}