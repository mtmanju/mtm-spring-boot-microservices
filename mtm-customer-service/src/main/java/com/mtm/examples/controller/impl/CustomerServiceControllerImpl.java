package com.mtm.examples.controller.impl;

import com.mtm.examples.client.AccountClient;
import com.mtm.examples.controller.CustomerServiceController;
import com.mtm.examples.domain.Account;
import com.mtm.examples.domain.Customer;
import com.mtm.examples.domain.CustomerType;
import com.mtm.examples.service.CustomerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.mtm.examples.constants.CustomerServiceConstants.CUSTOMERS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
public class CustomerServiceControllerImpl implements CustomerServiceController {

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
    @HystrixCommand(fallbackMethod = "findCustomersFallback")
    public EntityModel<Customer> findCustomersByCustomerId(@RequestParam("customerId") Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findByCustomerId(%s)", customerId));
        Customer customer = customerService.findByCustomerId(customerId);
        List<Account> accounts = findAccountsByCustomerId(customerId);
        customer.setAccounts(accounts);
        return EntityModel.of(customer)
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customer.getCustomerId())).withSelfRel())
                .add(linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel(CUSTOMERS));
    }

    public EntityModel<Customer> findCustomersFallback(Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findCustomersFallback(%s)", customerId));
        return EntityModel.of(Customer.builder().customerId(1).pesel("12345").name("Manjunath").type(CustomerType.INDIVIDUAL).build()).add(linkTo(methodOn(CustomerServiceControllerImpl.class).findCustomersByCustomerId(customerId)).withSelfRel()).add(linkTo(methodOn(CustomerServiceControllerImpl.class).findAll()).withRel(CUSTOMERS));
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
    @HystrixCommand(fallbackMethod = "findAccountsByCustomerIdFallback")
    public List<Account> findAccountsByCustomerId(@RequestParam("customerId") Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerId(%s)", customerId));
        return accountClient.getAccounts(customerId);
    }

    public List<Account> findAccountsByCustomerIdFallback(Integer customerId) {
        log.info(String.format("CustomerServiceControllerImpl.findAccountsByCustomerIdFallback(%s)", customerId));
        List<Account> accounts = new ArrayList<>();
        accounts.add(Account.builder().accountId(1).number("123456").build());
        return accounts;
    }

}