package com.mtm.examples.service;

import java.util.List;

import com.mtm.examples.domain.Account;

public interface AccountService {

	public Account findByAccountNumber(String accountNumber);

	public List<Account> findByCustomerId(Integer customerId);

	public List<Account> findAllAccounts();

}
