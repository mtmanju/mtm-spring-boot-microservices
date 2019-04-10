package com.mtm.examples.controller;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.domain.Account;

@RequestMapping("/accounts")
public interface AccountServiceController {

	Resource<Account> findByNumber(String accountNumber);

	List<Account> findByCustomerId(Integer customerId);

	List<Account> findAll();

}