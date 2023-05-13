package com.mtm.examples.service;

import com.mtm.examples.domain.Account;

import java.util.List;

public interface AccountService {

    public Account findByAccountNumber(String accountNumber);

    public List<Account> findByCustomerId(Integer customerId);

    public List<Account> findAllAccounts();

}
