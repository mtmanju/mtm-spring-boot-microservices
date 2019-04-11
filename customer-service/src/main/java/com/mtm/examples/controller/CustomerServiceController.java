package com.mtm.examples.controller;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.domain.Account;
import com.mtm.examples.domain.Customer;

@RequestMapping("/customers")
public interface CustomerServiceController {

	Resource<Customer> findCustomersByCustomerId(Integer customerId);

	Resource<Customer> findByPesel(String pesel);

	List<Customer> findAll();

	List<Account> findAccountsByCustomerId(Integer customerId);

}