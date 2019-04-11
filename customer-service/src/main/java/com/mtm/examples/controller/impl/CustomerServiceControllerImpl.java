package com.mtm.examples.controller.impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.client.AccountClient;
import com.mtm.examples.controller.CustomerServiceController;
import com.mtm.examples.domain.Account;
import com.mtm.examples.domain.Customer;
import com.mtm.examples.domain.CustomerType;
import com.mtm.examples.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CustomerServiceControllerImpl implements CustomerServiceController {
	private static Logger LOGGER = Logger.getLogger(CustomerServiceControllerImpl.class.getName());

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountClient accountClient;

	@Override
	@RequestMapping("/pesel")
	public Resource<Customer> findByPesel(@RequestParam("pesel") String pesel) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findByPesel(%s)", pesel));
		Customer customer = customerService.findByPesel(pesel);
		return new Resource<>(customer,
				linkTo(methodOn(CustomerServiceControllerImpl.class).findByPesel(customer.getPesel())).withSelfRel(),
				linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel("customers"));
	}

	@Override
	@RequestMapping
	@HystrixCommand(fallbackMethod = "findCustomersFallback")
	public Resource<Customer> findCustomersByCustomerId(@RequestParam("customerId") Integer customerId) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findByCustomerId(%s)", customerId));
		Customer customer = customerService.findByCustomerId(customerId);
		List<Account> accounts = findAccountsByCustomerId(customerId);
		customer.setAccounts(accounts);
		return new Resource<>(customer,
				linkTo(methodOn(CustomerServiceControllerImpl.class)
						.findCustomersByCustomerId(customer.getCustomerId())).withSelfRel(),
				linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel("customers"));
	}

	public Resource<Customer> findCustomersFallback(Integer customerId) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findCustomersFallback(%s)", customerId));
		return new Resource<>(
				Customer.builder().customerId(1).pesel("12345").name("Manjunath").type(CustomerType.INDIVIDUAL).build(),
				linkTo(methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customerId))
						.withSelfRel(),
				linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel("customers"));
	}

	@Override
	@RequestMapping("/all")
	public List<Customer> findAll() {
		LOGGER.info("CustomerServiceControllerImpl.findAll()");
		List<Customer> customers = customerService.findAll();
		customers.stream().forEach(customer -> {
			customer.add(linkTo(
					methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customer.getCustomerId()))
							.withSelfRel());
		});
		return customers;
	}

	@Override
	@RequestMapping("/accounts")
	@HystrixCommand(fallbackMethod = "findAccountsByCustomerIdFallback")
	public List<Account> findAccountsByCustomerId(@RequestParam("customerId") Integer customerId) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerId(%s)", customerId));
		return accountClient.getAccounts(customerId);
	}

	public List<Account> findAccountsByCustomerIdFallback(Integer customerId) {
		LOGGER.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerIdFallback(%s)", customerId));
		List<Account> accounts = new ArrayList<>();
		accounts.add(Account.builder().accountId(1).number("123456").build());
		return accounts;
	}

}