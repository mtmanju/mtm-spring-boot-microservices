package com.mtm.examples.customers.controller.impl;

import static com.mtm.examples.customers.constants.CustomerServiceConstants.CUSTOMERS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.customers.client.AccountClient;
import com.mtm.examples.customers.controller.CustomerServiceController;
import com.mtm.examples.customers.domain.Account;
import com.mtm.examples.customers.domain.Customer;
import com.mtm.examples.customers.domain.CustomerType;
import com.mtm.examples.customers.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerServiceControllerImpl implements CustomerServiceController {

    private static final String CUSTOMER_SERVICE = "customerService";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountClient accountClient;

    @Override
    @GetMapping("/pesel")
    public EntityModel<Customer> findByPesel(@RequestParam("pesel") String pesel) {
        log.info(String.format("CustomerServiceControllerImpl.findByPesel(%s)", pesel));
        Customer customer = customerService.findByPesel(pesel);
        return EntityModel.of(customer)
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findByPesel(customer.getPesel())).withSelfRel())
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel(CUSTOMERS));
    }

    @Override
    @GetMapping
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "findCustomersFallback")
    public EntityModel<Customer> findCustomersByCustomerId(@RequestParam("customerId") Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findByCustomerId(%s)", customerId));
        Customer customer = customerService.findByCustomerId(customerId);
        List<Account> accounts = findAccountsByCustomerId(customerId);
        customer.setAccounts(accounts);
        return EntityModel.of(customer)
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customer.getCustomerId())).withSelfRel())
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel(CUSTOMERS));
    }

    public EntityModel<Customer> findCustomersFallback(Integer customerId, Exception ex) {
        log.info(String.format("CustomerServiceControllerImpl.findCustomersFallback(%s)", customerId));
        return EntityModel.of(Customer.builder().customerId(1).pesel("12345").name("Manjunath").type(CustomerType.INDIVIDUAL).build())
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customerId)).withSelfRel())
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel(CUSTOMERS));
    }

    @Override
    @GetMapping("/all")
    public List<Customer> findAll() {
        log.info("CustomerServiceControllerImpl.findAll()");
        List<Customer> customers = customerService.findAll();
        customers.stream().forEach(customer -> customer.add(linkTo(
                methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customer.getCustomerId()))
                .withSelfRel()));
        return customers;
    }

    @Override
    @GetMapping("/accounts")
    @CircuitBreaker(name = CUSTOMER_SERVICE, fallbackMethod = "findAccountsByCustomerIdFallback")
    public List<Account> findAccountsByCustomerId(@RequestParam("customerId") Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerId(%s)", customerId));
        return accountClient.getAccounts(customerId);
    }

    public List<Account> findAccountsByCustomerIdFallback(Integer customerId, Exception ex) {
        log.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerIdFallback(%s)", customerId));
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().accountId(1).number("123456").build());
        return accounts;
    }

}