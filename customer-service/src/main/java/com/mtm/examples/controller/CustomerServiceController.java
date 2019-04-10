package com.mtm.examples.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.domain.Customer;

@RequestMapping("/customers")
public interface CustomerServiceController {

	Customer findByCustomerId(Integer customerId);

	Customer findByPesel(String pesel);

	List<Customer> findAll();

}