package com.mtm.examples.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.domain.Customer;

@RequestMapping("/accounts")
public interface CustomerServiceController {

	Customer findByPesel(String pesel);

	Customer findById(Integer id);

	List<Customer> findAll();

}
