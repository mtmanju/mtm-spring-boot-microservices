package com.mtm.examples.controller.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.controller.AccountServiceController;
import com.mtm.examples.domain.Account;
import com.mtm.examples.service.AccountService;

@RestController
public class AccountServiceControllerImpl implements AccountServiceController {
	private static Logger LOGGER = Logger.getLogger(AccountServiceControllerImpl.class.getName());

	@Autowired
	private AccountService accountService;

	@Override
	@RequestMapping
	public List<Account> findAll() {
		LOGGER.info("AccountServiceControllerImpl.findAll()");
		List<Account> accounts = accountService.findAllAccounts();
		accounts.stream().forEach(account -> {
			account.add(linkTo(methodOn(AccountServiceControllerImpl.class).findByNumber(account.getNumber()))
					.withSelfRel());
		});
		return accounts;
	}

	@Override
	@RequestMapping("/{number}")
	public Resource<Account> findByNumber(@PathVariable("number") String number) {
		LOGGER.info(String.format("AccountServiceControllerImpl.findByNumber(%s)", number));
		Account account = accountService.findByAccountNumber(number);
		return new Resource<>(account,
				linkTo(methodOn(AccountServiceControllerImpl.class).findByNumber(account.getNumber())).withSelfRel(),
				linkTo(methodOn(AccountServiceControllerImpl.class).findAll()).withRel("accounts"));
	}

	@Override
	@RequestMapping("/customer/{customerId}")
	public List<Account> findByCustomerId(@PathVariable("customerId") Integer customerId) {
		LOGGER.info(String.format("AccountServiceControllerImpl.findByCustomerId(%s)", customerId));
		List<Account> accounts = accountService.findByCustomerId(customerId);
		accounts.stream().forEach(account -> {
			account.add(linkTo(methodOn(AccountServiceControllerImpl.class).findByCustomerId(account.getCustomerId()))
					.withSelfRel());
		});
		return accounts;
	}

}
