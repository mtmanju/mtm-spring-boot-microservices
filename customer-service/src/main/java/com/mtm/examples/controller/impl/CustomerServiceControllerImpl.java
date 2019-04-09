package com.mtm.examples.controller.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.client.AccountClient;
import com.mtm.examples.controller.CustomerServiceController;
import com.mtm.examples.domain.Account;
import com.mtm.examples.domain.Customer;
import com.mtm.examples.service.CustomerService;

@RestController
public class CustomerServiceControllerImpl implements CustomerServiceController {
	private static Logger LOGGER = Logger.getLogger(CustomerServiceControllerImpl.class.getName());

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountClient accountClient;

	@Override
	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findByPesel(%s)", pesel));
		return customerService.findByPesel(pesel);
	}

	@Override
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findById(%s)", id));
		Customer customer = customerService.findById(id);
		List<Account> accounts = accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}

	@Override
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		LOGGER.info("CustomerServiceControllerImpl.findAll()");
		return customerService.findAll();
	}

}
