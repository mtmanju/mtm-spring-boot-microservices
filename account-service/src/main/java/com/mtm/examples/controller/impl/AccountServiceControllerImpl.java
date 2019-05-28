package com.mtm.examples.controller.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.controller.AccountServiceController;
import com.mtm.examples.domain.Account;
import com.mtm.examples.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountServiceControllerImpl implements AccountServiceController {

	@Autowired
	private AccountService accountService;

	@Override
	@GetMapping
	public List<Account> findAll() {
		log.info("AccountServiceControllerImpl.findAll()");
		List<Account> accounts = accountService.findAllAccounts();
		accounts.stream().forEach(account -> account.add(
				linkTo(methodOn(AccountServiceControllerImpl.class).findByNumber(account.getNumber())).withSelfRel()));
		return accounts;
	}

	@Override
	@GetMapping("/{number}")
	public Resource<Account> findByNumber(@PathVariable("number") String number) {
		log.info(String.format("AccountServiceControllerImpl.findByNumber(%s)", number));
		Account account = accountService.findByAccountNumber(number);
		return new Resource<>(account,
				linkTo(methodOn(AccountServiceControllerImpl.class).findByNumber(account.getNumber())).withSelfRel(),
				linkTo(methodOn(AccountServiceControllerImpl.class).findAll()).withRel("accounts"));
	}

	@Override
	@GetMapping("/customer/{customerId}")
	public List<Account> findByCustomerId(@PathVariable("customerId") Integer customerId) {
		log.info(String.format("AccountServiceControllerImpl.findByCustomerId(%s)", customerId));
		List<Account> accounts = accountService.findByCustomerId(customerId);
		accounts.stream()
				.forEach(account -> account.add(
						linkTo(methodOn(AccountServiceControllerImpl.class).findByCustomerId(account.getCustomerId()))
								.withSelfRel()));
		return accounts;
	}

}