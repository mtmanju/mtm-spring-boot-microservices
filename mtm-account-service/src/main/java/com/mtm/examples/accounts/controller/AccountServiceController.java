package com.mtm.examples.accounts.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtm.examples.accounts.domain.Account;

import java.util.List;

@RequestMapping("/accounts")
public interface AccountServiceController {

    EntityModel<Account> findByNumber(String accountNumber);

    List<Account> findByCustomerId(Integer customerId);

    List<Account> findAll();

}