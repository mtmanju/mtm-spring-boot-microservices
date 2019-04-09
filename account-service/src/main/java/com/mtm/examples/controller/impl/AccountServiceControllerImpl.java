package com.mtm.examples.controller.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Account> findAllAccounts() {
		LOGGER.info("AccountServiceControllerImpl.findAll()");
		return accountService.findAllAccounts();
	}

	@Override
	@RequestMapping("/{accountNumber}")
	public Account findByNumber(@PathVariable("accountNumber") String accountNumber) {
		LOGGER.info(String.format("AccountServiceControllerImpl.findByNumber(%s)", accountNumber));
		return accountService.findByAccountNumber(accountNumber);
	}

	@Override
	@RequestMapping("/customer/{customerId}")
	public List<Account> findByCustomerId(@PathVariable("customerId") Integer customerId) {
		LOGGER.info(String.format("AccountServiceControllerImpl.findByCustomerId(%s)", customerId));
		return accountService.findByCustomerId(customerId);
	}

}
