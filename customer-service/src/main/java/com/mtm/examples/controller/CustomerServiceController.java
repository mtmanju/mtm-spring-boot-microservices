package com.mtm.examples.controller;

import com.mtm.examples.domain.Account;
import com.mtm.examples.domain.Customer;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/customers")
public interface CustomerServiceController {

    EntityModel<Customer> findCustomersByCustomerId(Integer customerId);

    EntityModel<Customer> findByPesel(String pesel);

    List<Customer> findAll();

    List<Account> findAccountsByCustomerId(Integer customerId);

}