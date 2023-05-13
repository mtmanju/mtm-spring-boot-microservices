package com.mtm.examples.controller;

import com.mtm.examples.domain.Account;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/accounts")
public interface AccountServiceController {

    EntityModel<Account> findByNumber(String accountNumber);

    List<Account> findByCustomerId(Integer customerId);

    List<Account> findAll();

}